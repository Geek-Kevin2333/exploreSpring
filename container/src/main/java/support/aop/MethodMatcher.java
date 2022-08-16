package support.aop;

import java.lang.reflect.Method;

/**
 *  * Part of a Pointcut: Checks whether the target method is eligible for advice.
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
