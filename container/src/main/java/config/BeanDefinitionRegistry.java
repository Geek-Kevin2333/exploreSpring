package config;

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
