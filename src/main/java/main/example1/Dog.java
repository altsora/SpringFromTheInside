package main.example1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dog {

    @PostConstruct
    public void init() {
        System.out.println("\t= Инит-метод " + this.getClass().getSimpleName());
    }
}
