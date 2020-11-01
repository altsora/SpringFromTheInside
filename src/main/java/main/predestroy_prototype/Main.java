package main.predestroy_prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(Coffee.class);
        context.getBean(Tea.class);
        context.getBean(Water.class);
        context.getBean(Milk.class);
        context.getBean(Lemonade.class);
        context.getBean(CoffeeMachine.class);
    }
}
