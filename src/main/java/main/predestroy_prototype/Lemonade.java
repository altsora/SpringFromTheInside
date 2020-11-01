package main.predestroy_prototype;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Lemonade {
    public Lemonade() {
        System.out.println("о Создаётся бин lemonade (XML): стоит аннотация @PreDestroy");
    }

    @PostConstruct
    public void init() {
        System.out.println("\t$ Инит " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void waterDestroy() {
        System.out.println("x Дестрой " + this.getClass().getSimpleName());
    }
}
