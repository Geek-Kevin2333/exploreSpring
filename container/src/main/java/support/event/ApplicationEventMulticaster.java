package support.event;

import config.ApplicationEvent;
import config.ApplicationListener;

public interface ApplicationEventMulticaster {
    /**
     * add a listener to be notified of all events
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * remove a listener from notification list.
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * multicast the event to appropriate notification list.
     */
    void multicastEvent(ApplicationEvent event);

}
