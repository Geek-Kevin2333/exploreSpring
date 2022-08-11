import cn.hutool.core.io.IoUtil;
import core.io.DefaultResourceLoader;
import core.io.Resource;
import org.junit.Before;
import org.junit.Test;
import support.DefaultListableBeanFactory;
import support.reader.XmlBeanDefinitionReader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Kevin
 * @Description
 */
public class ReaderTest {
    private DefaultResourceLoader resourceLoader;

    /**
     * unit中集中基本注解，是必须掌握的
     * @BeforeClass – 表示在类中的任意public static void方法执行之前执行
     * @AfterClass – 表示在类中的任意public static void方法执行之后执行
     * @Before – 表示在任意使用@Test注解标注的public void方法执行之前执行
     * @After – 表示在任意使用@Test注解标注的public void方法执行之后执行
     * @Test – 使用该注解标注的public void方法会表示为一个测试方法
     */
    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

}
