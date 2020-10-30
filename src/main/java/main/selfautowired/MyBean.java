package main.selfautowired;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MyBean implements MyBeanInterface {

    @SelfAutowired
    private MyBean myBean1;

    private MyBean myBean2;

    public void sayHello() {
        System.out.println("Hello, Spring!");
        System.out.println("@SelfAutowired myBean1 == null: " + (myBean1 == null));
        System.out.println(".............. myBean2 == null: " + (myBean2 == null));
    }
}
