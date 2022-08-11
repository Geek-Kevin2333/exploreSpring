import config.BeanDefinition;
import config.BeanReference;
import config.PropertyValue;
import config.PropertyValues;
import org.junit.Assert;
import org.junit.Test;
import support.DefaultListableBeanFactory;

/**
 * @author Kevin
 * @Description
 */
public class BeanFactoryTest {

    /**
     * 测试创建beanDefinition，获得bean对象，以及bean的单例模式
     */
    @Test
    public void test_BeanFactory(){
        //1.初始化 beanFactory
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        //2.UserDao注册
        beanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        //3.UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid","1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        //4.UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //5. UserService获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();


    }

    @Test
    public void beanFactory_args(){
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService bean = (UserService) beanFactory.getBean("userService", "小强");

        bean.queryUserInfo();
    }
}
