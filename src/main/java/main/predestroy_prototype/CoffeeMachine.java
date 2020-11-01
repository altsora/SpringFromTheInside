package main.predestroy_prototype;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CoffeeMachine {
    @PostConstruct
    public void init() {
        System.out.println("\t$ Инит " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("x Дестрой " + this.getClass().getSimpleName());
    }
}
