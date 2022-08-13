package support.factory;

import config.BeanDefinition;
import config.BeanPostProcessor;
import config.FactoryBean;
import support.factoryBeanRegistry.FactoryBeanRegistrySupport;
import support.instantiationStrategy.DefaultSingletonBeanRegistry;
import util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @Description
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    /**
     * @param name
     * @param args 实例化bean需要的参数
     * @return 重载了一个含有入参信息 args 的 getBean 方法，这样就可以方便的传递入参给构造函数实例化了
     */
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    /**
     * 存储了Bean的定义，所以返回的是Class对象
     *
     * @param name
     */

    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    public <T> T getBean(String name, Class<T> requiredType) {
        return (T) getBean(name);
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = null;
        try {
            beanDefinition = getBeanDefinition(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }
    // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
    private Object getObjectForBeanInstance(Object beanInstance,String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }
}
