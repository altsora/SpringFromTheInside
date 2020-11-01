package main.predestroy_prototype;

import javax.annotation.PostConstruct;

public class Milk {

    @PostConstruct
    public void init() {
        System.out.println("\t$ Инит " + this.getClass().getSimpleName());
    }

    public void milkDestroy() {
        System.out.println("x Дестрой " + this.getClass().getSimpleName());
    }

}
