import config.BeanDefinition;
import org.junit.Assert;
import org.junit.Test;
import support.DefaultListableBeanFactory;

/**
 * @author Kevin
 * @Description
 */
public class Apitest {

    /**
     * 测试创建beanDefinition，获得bean对象，以及bean的单例模式
     */
    @Test
    public void test_BeanFactory(){

        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService_singleton = (UserService) beanFactory.getBean("userService");

        Assert.assertEquals(userService,userService_singleton);


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
