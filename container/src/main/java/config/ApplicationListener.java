package config;

import java.util.EventListener;

public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * handle an application event.
     */
    void onApplicationEvent(E event);
}
