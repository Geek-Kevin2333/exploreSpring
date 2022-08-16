import config.ApplicationListener;

/**
 * @author Kevin
 * @Description
 */
public class CustomerEventListener implements ApplicationListener<CustomEvent> {
    /**
     * handle an application event.
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到" + event.getSource() + "消息o");
        System.out.println("消息为：" + event.getId() + ":" + event.getMessage());
    }
}
