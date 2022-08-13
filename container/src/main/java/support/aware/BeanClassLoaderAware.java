package support.aware;

/**
 * 实现此接口的bean可以感知到加载它的Classloader是什么
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
