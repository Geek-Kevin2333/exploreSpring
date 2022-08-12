package context;

import config.BeanFactoryPostProcessor;
import config.BeanPostProcessor;
import core.io.DefaultResourceLoader;
import support.ConfigurableListableBeanFactory;

import java.util.Map;

/**
 * @author Kevin
 * 为什么需要把另外把定义出来的抽象方法， refreshBeanFactory()、 getBeanFactory() 由后面的继承此抽象类的其他抽象类实现？
 * ApplicationContext依赖于DefaultListableBeanFactory。本类更类似于一个模板方法设计模式中的模板类
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() {
//       1.创建beanFactory，并加载beanDefinition
        refreshBeanFactory();
//       2.获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
//       3.在bean注册之后，修改beanDefinition
        invokeBeanFactoryPostProcessors(beanFactory);
//       4.BeanPostProcessors需要提前于其它Bean对象之前执行注册操作 ，先删后加，有一个顺序问题，所以能达到BeanPostProcessors提前于其它Bean对象之前执行实例化操作的目的
        registerBeanPostProcessors(beanFactory);
//       5.提前实例化单例bean对象
        beanFactory.preInstantiateSingleton();
    }


    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args)  {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType)  {
        return getBeanFactory().getBean(name, requiredType);
    }

    /**
     * 返回注册表中所有的Bean名称
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    protected abstract void refreshBeanFactory();

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

}
