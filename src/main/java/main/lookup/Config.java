package main.lookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class Config {

    @Bean
    @Scope("prototype")
    public Passenger2 passenger2() {
        return new Passenger2();
    }
}
