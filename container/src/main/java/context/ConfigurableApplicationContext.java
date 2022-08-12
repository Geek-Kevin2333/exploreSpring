package context;

public interface ConfigurableApplicationContext extends ApplicationContext {
    void refresh();

    /**
     * 定义注册虚拟机钩子的方法 registerShutdownHook
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭的方法 close
     */
    void close();

}
