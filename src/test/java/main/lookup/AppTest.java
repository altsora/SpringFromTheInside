package main.lookup;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {main.lookup.Config.class})
public class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextNotNull() {
        Assert.assertNotNull(context);
        System.out.println("Context not null");
    }

    @Test
    public void beanPassenger1ExistsAndPrototype() {
        Passenger1 passenger1_1 = context.getBean(Passenger1.class);
        Passenger1 passenger1_2 = context.getBean(Passenger1.class);
        Assert.assertNotNull(passenger1_1);
        Assert.assertNotNull(passenger1_2);
        Assert.assertNotEquals(passenger1_1, passenger1_2);
        System.out.println("Passenger1_1 != Passenger1_2");
    }

    @Test
    public void beanPassenger2Exists() {
        Passenger2 passenger2_1 = context.getBean(Passenger2.class);
        Passenger2 passenger2_2 = context.getBean(Passenger2.class);
        Assert.assertNotNull(passenger2_1);
        Assert.assertNotNull(passenger2_2);
        Assert.assertNotEquals(passenger2_1, passenger2_2);
        System.out.println("Passenger2_1 != Passenger2_2");
    }

    @Test
    public void CarWithPrototypePassenger1AndPrototypePassenger2() {
        Car car1 = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);
        Assert.assertNotNull(car1);
        Assert.assertNotNull(car2);
        Assert.assertEquals(car1, car2);
        car1.drive("Bob", "Alex");
    }
}