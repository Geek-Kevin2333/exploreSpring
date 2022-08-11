package support.reader;

import config.BeanDefinitionRegistry;
import core.io.DefaultResourceLoader;
import core.io.ResourceLoader;

/**
 * @author Kevin
 * 抽象类把 BeanDefinitionReader 接口的前两个方法全部实现完了，并提供了构造
 * 函数，让外部的调用使用方，把 Bean 定义注入类，传递进来。
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
