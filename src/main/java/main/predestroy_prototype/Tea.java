package main.predestroy_prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Tea {
    public Tea() {
        System.out.println("о Создаётся бин tea (@Component): аннотация @PreDestroy указана над методом, над классом нет @PreDestroyClass");
    }

    @PostConstruct
    public void init() {
        System.out.println("\t$ Инит " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void milkDestroy() {
        System.out.println("x Дестрой " + this.getClass().getSimpleName());
    }
}
