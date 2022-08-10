package config;

/**
 * 为什么只有一个getSingleton接口，因为考虑到单例实现方式有多种，最核心的方法
 * 只有getSingleton
 */
public interface SingletonBeanRegistry {
    public Object getSingleton(String beanName);
}
