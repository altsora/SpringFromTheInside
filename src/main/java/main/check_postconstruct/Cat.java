package main.check_postconstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Cat {

    @Autowired
    private Human human;

    @PostConstruct
    private void init() {
        System.out.println("init");
    }
}
