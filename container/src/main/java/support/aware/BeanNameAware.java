package support.aware;

/**
 * 实现此接口的bean知道它在beanFactory中的name
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
