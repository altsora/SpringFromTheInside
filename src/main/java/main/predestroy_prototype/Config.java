package main.predestroy_prototype;

import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@ComponentScan
@ImportResource("context.xml")
public class Config {

    @PostConstruct
    public void init() {
        System.out.println("\t$ Инит " + this.getClass().getSimpleName());
    }

    @Bean
    public static PreDestroyForPrototypeBeanPostProcessor preDestroyForPrototypeBeanPostProcessor() {
        System.out.println("о Создаётся бин preDestroyForPrototypeBeanPostProcessor (Config)");
        return new PreDestroyForPrototypeBeanPostProcessor();
    }

    @Bean
    public static PreDestroyAnnotationBeanFactoryPostProcessor preDestroyAnnotationBeanFactoryPostProcessor() {
        System.out.println("о Создаётся бин preDestroyAnnotationBeanFactoryPostProcessor (Config)");
        return new PreDestroyAnnotationBeanFactoryPostProcessor();
    }

    @Bean
    @Scope("prototype")
    public Coffee coffee() {
        System.out.println("о Создаётся бин coffee (Config): стоит аннотация @PreDestroy над методом");
        return new Coffee();
    }

    @Bean(destroyMethod = "milkDestroy")
    @Scope("prototype")
    public Milk milk() {
        System.out.println("о Создаётся бин milk (Config): Destroy-метод указан в @Bean");
        return new Milk();
    }

    @Bean
    @Scope("singleton")
    public CoffeeMachine coffeeMachine() {
        System.out.println("о Создаётся бин coffeeMachine (Config): стоит аннотация @PreDestroy над методом");
        return new CoffeeMachine();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("x Дестрой " + this.getClass().getSimpleName());
    }
}
