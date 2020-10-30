package main.example1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {main.example1.Config.class})
public class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextNotNull() {
        System.out.println("************** Context not null **************");
        Assert.assertNotNull(context);
        System.out.println("************** **************** **************");
    }
}