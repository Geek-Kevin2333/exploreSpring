package support.factoryBeanRegistry;

import config.FactoryBean;
import support.instantiationStrategy.DefaultSingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Kevin
 * @Description
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    public Map<String, Object> getFactoryBeanObjectCache() {
        return factoryBeanObjectCache;
    }

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                factoryBeanObjectCache.put(beanName, object != null ? object : NULL_OBJECT);
            }
            return object != NULL_OBJECT ? object : null;
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
        return factory.getObject();
    }
}
