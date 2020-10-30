package main.screensaver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {main.screensaver.Config.class})
public class ScreenSaverTest {

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
        System.out.println("Context not null");
    }

    @Test
    public void colorScopePrototype() {
        title("Color scope is prototype");
        Color color1 = context.getBean("color", Color.class);
        Color color2 = context.getBean("color", Color.class);
        Assert.assertNotEquals(color1, color2);
        System.out.println(color1);
        System.out.println(color2);
    }

    @Test
    public void beanFrameNotNull() {
        title("Bean \"frame\" not null");
        ColorFrame colorFrame = context.getBean("frame", ColorFrame.class);
        Assert.assertNotNull("Bean \"frame\" is null", colorFrame);
        System.out.println("Bean not null");
    }

    @Test
    public void beanFrameTimerNotNull() {
        title("Bean \"frameTimer\" not null");
        Assert.assertNotNull("Bean \"frameTimer\" null", context.getBean("frameTimer", ColorFrame.class));
        System.out.println("Bean not null");
    }

    private void title(String text) {
        String format = "%s %s %s";
        System.out.println(String.format(format,
                "*".repeat(10), text, "*".repeat(10)));
    }
}