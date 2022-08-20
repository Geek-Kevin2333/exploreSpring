package config;

/**
 * Subinterface of {@link BeanPostProcessor} that adds a before-instantiation callback,
 * and a callback after instantiation but before explicit properties are set or
 * autowiring occurs.
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * 实例化之前
     * @param beanName
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName);

}
