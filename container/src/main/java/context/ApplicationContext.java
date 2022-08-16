package context;

import config.ApplicationEventPublisher;
import support.factory.ListableBeanFactory;

public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher {

}
