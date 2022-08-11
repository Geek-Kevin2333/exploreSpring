package support;

public interface BeanFactory {
    /**
     * 存储了Bean的定义，所以返回的是Class对象
     */
    Object getBean(String name);

    /**
     * @param args  实例化bean需要的参数
     * @return
     * 重载了一个含有入参信息 args 的 getBean 方法，这样就可以方便的传递入参给构造函数实例化了
     */
    Object getBean(String name,Object...args);

    <T> T getBean(String name, Class<T> requiredType) ;

}
