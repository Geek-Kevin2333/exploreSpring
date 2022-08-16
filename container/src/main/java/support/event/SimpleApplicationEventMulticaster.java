package support.event;

import config.ApplicationEvent;
import config.ApplicationListener;
import support.factory.BeanFactory;
import support.factory.ConfigurableListableBeanFactory;

/**
 * @author Kevin
 * @Description
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    /**
     * multicast the event to appropriate notification list.
     *
     * @param event
     */
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListener(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
