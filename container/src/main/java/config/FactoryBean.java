package config;

public interface FactoryBean<T> {
    T getObject();

    Class<?> getObjectType();

    boolean isSingleton();

}
