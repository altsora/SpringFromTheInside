package main.predestroy_prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
@PreDestroyClass(destroyMethod = "juiceDestroy")
public class Juice {

    public Juice() {
        System.out.println("о Создаётся бин juice (@Component): указана собственная аннотация @PreDestroyClass над классом");
    }

    @PostConstruct
    public void init() {
        System.out.println("\t$ Инит " + this.getClass().getSimpleName());
    }

    public void juiceDestroy() {
        System.out.println("x Дестрой " + this.getClass().getSimpleName());
    }
}
