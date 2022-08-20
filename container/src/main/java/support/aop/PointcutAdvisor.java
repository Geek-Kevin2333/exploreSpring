package support.aop;

import org.aopalliance.aop.Advice;

/**
 * @author Kevin
Advisor 承担了 Pointcut 和 Advice 的组合， Pointcut 用于获取 JoinPoint，而Advice 决定于 JoinPoint 执行什么操作
 */
public interface PointcutAdvisor extends Advisor {
    /**
     * get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
