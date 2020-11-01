package main.predestroy_prototype;

import org.springframework.beans.factory.annotation.Autowired;

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
