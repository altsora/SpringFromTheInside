package main.example1;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.awt.*;

@ToString
public class Cat implements Animal {
    private String name;

    @RandomInt(min = 1, max = 10)
    private int age;

    @Autowired
    private Color color;

    public Cat(String name) {
        System.out.println("+ Конструктор " + this.getClass().getSimpleName());
        this.name = name;
        System.out.println("\tname = " + name);
        System.out.println("\tage = " + age);
        System.out.println("\tcolor = " + color);
    }

    @PostConstruct
    public void init() {
        System.out.println("\t= Инит-метод " + this.getClass().getSimpleName());
        System.out.println("\t\tname = " + name);
        System.out.println("\t\tage = " + age);
        System.out.println("\t\tcolor = " + color);
    }

    @Override
    public void aboutMe() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("color = " + color);
    }
}
