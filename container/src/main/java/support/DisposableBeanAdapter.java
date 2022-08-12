package support;

import cn.hutool.core.util.StrUtil;
import config.BeanDefinition;
import config.DisposableBean;

import java.lang.reflect.Method;

/**
 * @author Kevin
 * 这里怎么有一个适配器的类呢，因为销毁方法有两种甚至多种方式，目前有实现接口 DisposableBean、 配置信息 destroy-method，两种方式。
   而这两种方式的销毁动作是由 AbstractApplicationContext 在注册虚拟机钩子后看，虚拟机关闭前执行的操作动作。
 * 那么在销毁执行时不太希望还得关注都销毁那些类型的方法，它的使用上更希望是有一个统一的接口进行销毁，所以这里就新增了适配类，做统一处理
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String name;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String name, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.name = name;
        this.destroyMethodName= beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean)) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);

            destroyMethod.invoke(bean);
        }
    }
}
