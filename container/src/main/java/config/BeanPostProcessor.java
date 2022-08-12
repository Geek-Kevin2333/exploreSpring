package config;

public interface BeanPostProcessor {

    /**
     * 实例化之后，初始化之前
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);

}
