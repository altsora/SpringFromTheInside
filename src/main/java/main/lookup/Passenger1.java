package main.lookup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Passenger1 {
    @Getter
    @Setter
    private String name;
}
