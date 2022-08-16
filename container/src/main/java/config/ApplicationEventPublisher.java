package config;

public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of
     * an event
     */
    void publishEvent(ApplicationEvent event);
}
