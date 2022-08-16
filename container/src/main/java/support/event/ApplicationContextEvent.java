package support.event;

import config.ApplicationEvent;
import context.ApplicationContext;

/**
 * @author Kevin
 * @Description
 */
public class ApplicationContextEvent extends ApplicationEvent {
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * @return get the applicationContext that the event is raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
