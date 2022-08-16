package support.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author Kevin}
AdvisedSupport，主要是用于把代理、拦截、匹配的各项属性包装到一个类中，方
便在 Proxy 实现类进行使用。 这和你的业务开发中包装入参是一个道理
TargetSource，是一个目标对象，在目标对象类中提供 Object 入参属性，以及获
取目标类 TargetClass 信息。
MethodInterceptor，是一个具体拦截方法实现类，由用户自己实现
MethodInterceptor#invoke 方法，做具体的处理。 像我们本文的案例中是做方法监
控处理
MethodMatcher，是一个匹配方法的操作，这个对象由 AspectJExpressionPointcut
提供服务
 */
public class AdvisedSupport {
    private TargetSource targetSource;
    private MethodMatcher methodMatcher;
    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
