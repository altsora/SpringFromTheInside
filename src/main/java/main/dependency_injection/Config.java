package main.dependency_injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {

    @Bean
    public CarWithSetter carWithSetter() {
        CarWithSetter carWithSetter = new CarWithSetter();
        return carWithSetter;
    }
}
