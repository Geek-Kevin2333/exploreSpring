package support;

import config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @Description
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        this.singletonObjects.put(beanName,singletonObject);
    }
}
