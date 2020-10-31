package main.dependency_injection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {main.dependency_injection.Config.class})
public class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextNotNull() {
        Assert.assertNotNull(context);
        System.out.println("Context not null");
    }

    @Test
    public void beanEngineExists() {
        Assert.assertNotNull(context.getBean(Engine.class));
        System.out.println("Bean engine exists");
    }

    @Test
    public void beanCarWithConstructorExists() {
        Assert.assertNotNull(context.getBean(CarWithConstructor.class));
        System.out.println("Bean carWithConstructor exists");
    }

    @Test
    public void beanCarWithSetterExists() {
        Assert.assertNotNull(context.getBean(CarWithSetter.class));
        System.out.println("Bean carWithSetter exists");
    }

    @Test
    public void beanCarWithNothingExists() {
        Assert.assertNotNull(context.getBean(CarSimple.class));
        System.out.println("Bean carSimple exists");
    }

    @Test
    public void injectionEngineInCarWithConstructorDone() {
        CarWithConstructor carWithConstructor = context.getBean(CarWithConstructor.class);
        Assert.assertNotNull(carWithConstructor);
        System.out.println("Bean carWithConstructor exists");
        Engine engine = carWithConstructor.getEngine();
        Assert.assertNotNull(engine);
        System.out.println("Bean engine exists");
    }

    @Test
    public void injectionEngineInCarWithSetterDone() {
        CarWithSetter carWithSetter = context.getBean(CarWithSetter.class);
        Assert.assertNotNull(carWithSetter);
        System.out.println("Bean carWithSetter exists");
        Engine engine = carWithSetter.getEngine();
        Assert.assertNotNull(engine);
        System.out.println("Bean engine exists");
    }

    @Test
    public void injectionEngineInCarSimpleDone() {
        CarSimple carSimple = context.getBean(CarSimple.class);
        Assert.assertNotNull(carSimple);
        System.out.println("Bean carSimple exists");
        Engine engine = carSimple.getEngine();
        Assert.assertNotNull(engine);
        System.out.println("Bean engine exists");
    }
}