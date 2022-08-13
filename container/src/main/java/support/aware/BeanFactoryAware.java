package support.aware;

import support.factory.BeanFactory;

/**
 * Interface to be implemented by beans that wish to be aware of their owning
 * 实现此接口的bean可以感知到它属于哪一个BeanFactory
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory);
}
