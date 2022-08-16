package support.event;

import cn.hutool.core.util.ClassUtil;
import config.ApplicationEvent;
import config.ApplicationListener;
import support.aware.BeanFactoryAware;
import support.factory.BeanFactory;
import util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author Kevin
 * AbstractApplicationEventMulticaster 是对事件广播器的公用方法提取，在这个类中可以实现一些基本功能，避免所有直接实现接口放还需要处理细节。
 * 除了像 addApplicationListener、 removeApplicationListener，这样的通用方法，这里这个类中主要是对 getApplicationListeners 和 supportsEvent 的处理。
 * getApplicationListeners 方法主要是摘取符合广播事件中的监听处理器，具体过滤动作在 supportsEvent 方法中。
 * 在 supportsEvent 方法中，主要包括对 Cglib、 Simple 不同实例化需要获取目标Class， Cglib 代理类需要获取父类的 Class，普通实例化的不需要。接下来就是通过
 * 提取接口和对应的 ParameterizedType 和 eventClassName，方便最后确认是否为子类和父类的关系，以此证明此事件归这个符合的类处理。
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * add a listener to be notified of all events
     *
     * @param listener
     */
    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    /**
     * remove a listener from notification list.
     *
     * @param listener
     */
    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    protected Collection<ApplicationListener> getApplicationListener(ApplicationEvent event){
        LinkedList<ApplicationListener> allListeners = new LinkedList<>();
        for (ApplicationListener<ApplicationEvent> listener :
                applicationListeners) {
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];
        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName = null;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return eventClassName.isAssignableFrom(event.getClass());
    }
}
