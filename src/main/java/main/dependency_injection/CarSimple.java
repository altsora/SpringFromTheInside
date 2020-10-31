package main.dependency_injection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarSimple {
    @Autowired
    @Getter
    private Engine engine;
}
