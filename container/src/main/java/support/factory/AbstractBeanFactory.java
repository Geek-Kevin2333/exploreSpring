package support.factory;

import cn.hutool.core.util.ClassUtil;
import config.BeanDefinition;
import config.BeanPostProcessor;
import support.DefaultSingletonBeanRegistry;
import util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @Description
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object[]args);

    /**
     * @param name
     * @param args 实例化bean需要的参数
     * @return 重载了一个含有入参信息 args 的 getBean 方法，这样就可以方便的传递入参给构造函数实例化了
     */
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
     * @param name
     */

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

    public <T> T getBean(String name, Class<T> requiredType) {
        return (T) getBean(name);
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
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
}
