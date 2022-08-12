package support.factory;

import config.BeanDefinition;
import config.BeanPostProcessor;

/**
 *   Configuration interface to be implemented by most listable bean factories.
 *   In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 *   analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 * Spring为什么要让ConfigurableListableBeanFactory继承这么多接口来实现一个Bean工厂呢？其实每个接口都有自己独特的功能，如ListableBeanFactory表示这些Bean是可列表的，
 * AutowireCapableBeanFactory定义了Bean的自动装配规则，ConfigurableBeanFactory允许Bean工厂自定义配置，如是单例模式还是原型模式。这样拆分再合并就可以按照接口的约束和规范来进行扩展操作。
 * ConfigurableListableBeanFactory最重要的是通过map存储了BeanDefinition。Spring通过以下方法创建ConfigurableListableBeanFactory，解析XML文件，加载BeanDefinition
 * todo 为什么ConfigurableListableBeanFactory需要这么设计，这样继承会不会很复杂，好处在哪。
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName);

    void preInstantiateSingleton();

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
