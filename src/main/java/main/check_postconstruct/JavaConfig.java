package main.check_postconstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaConfig {

    /**
     *  Проверка, распознаётся ли аннотация @PostConstruct, если создавать бины через @Component.
     *  Результат: аннотация распознаётся, инит-метод вызывается после before-обработки BPP.
     */
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(JavaConfig.class);
    }
}
