package support.aop;

/**
 * @author Kevin
 * 这个代理工厂主要处理的是关于JDK和CGlib两种代理的选择问题，有了代理工厂就可以按照不同的创建
 * 需求进行控制
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
