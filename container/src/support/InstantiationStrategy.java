package support;

import config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args);

}
