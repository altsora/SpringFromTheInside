package main.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan("main.example1")
public class Config {

    public Config() {
        System.out.println("+ Конструктор " + this.getClass().getSimpleName());
    }

    @PostConstruct
    public void init() {
        System.out.println("\t= Инит-метод " + this.getClass().getSimpleName());
    }

    @Bean
    public Cat cat() {
        System.out.println("x Создание бина cat");
        return new Cat("Murka");
    }

    @Bean
    public Color color() {
        System.out.println("x Создание бина color");
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

}
