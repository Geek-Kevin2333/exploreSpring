package support;

import config.BeanDefinition;
import support.BeanFactory;
/**
 * @author Kevin
 * @Description
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[]args);

    /**
     * @param name
     * @param args 实例化bean需要的参数
     * @return 重载了一个含有入参信息 args 的 getBean 方法，这样就可以方便的传递入参给构造函数实例化了
     */
    @Override
    public Object getBean(String name, Object... args) {
        Object bean=getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = null;
        try {
            beanDefinition = getBeanDefinition(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createBean(name,beanDefinition,args);
    }

    /**
     * 存储了Bean的定义，所以返回的是Class对象
     *
     * @param name
     */
    @Override
    public Object getBean(String name) {
        Object bean=getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = null;
        try {
            beanDefinition = getBeanDefinition(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createBean(name,beanDefinition,null);
    }

}
