package main.selfautowired;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {main.selfautowired.Config.class})
public class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextNotNull() {
        Assert.assertNotNull(context);
    }

    @Test
    public void beanExists() {
        MyBean myBean = context.getBean(MyBean.class);
        Assert.assertNotNull(myBean);
    }

    @Test
    public void selfAutowiredIsWorked() {
        MyBean myBean = context.getBean(MyBean.class);
        Assert.assertNotNull(myBean.getMyBean1());
        Assert.assertNull(myBean.getMyBean2());
    }
}