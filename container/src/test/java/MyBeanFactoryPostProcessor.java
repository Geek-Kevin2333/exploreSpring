import config.BeanDefinition;
import config.BeanFactoryPostProcessor;
import config.PropertyValue;
import config.PropertyValues;
import support.ConfigurableListableBeanFactory;

/**
 * @author Kevin
 * 实例化之前调用
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
