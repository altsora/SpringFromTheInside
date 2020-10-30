package main.selfautowired;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {main.selfautowired.Config.class})
public class SelfAutowiredTest {

    @Autowired
    private ApplicationContext context;

    @After
    public void after() {
        System.out.println("*".repeat(50));
    }

    @Test
    public void contextNotNull() {
        title("Context not null");
        Assert.assertNotNull(context);
    }

    @Test
    public void beanExists() {
        title("MyBean not null");
        Assert.assertNotNull(context.getBean(MyBean.class));
    }

    @Test
    public void selfAutowiredIsWorked() {

        title("@SelfAutowired is worked");
        MyBean myBean = context.getBean(MyBean.class);
        Assert.assertNotNull(myBean.getMyBean1());
        Assert.assertNull(myBean.getMyBean2());
    }

    private void title(String text) {
        String format = "%s %s %s";
        System.out.println(String.format(format,
                "*".repeat(10), text, "*".repeat(10)));
    }
}