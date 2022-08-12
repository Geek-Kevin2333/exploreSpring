package config;

/**
 * Bean处理了属性填充之后用
 */
public interface InitializingBean {
    void afterPropertiesSet();
}
