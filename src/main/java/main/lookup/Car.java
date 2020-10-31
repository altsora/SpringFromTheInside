package main.lookup;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Car {
    private Passenger1 passenger1;
    private Passenger2 passenger2;

    @Lookup
    public Passenger1 newPassenger1() {
        return null;
    }

    @Lookup
    public Passenger2 newPassenger2() {
        return null;
    }

    public void drive(String passengerName1, String passengerName2) {
        passenger1 = newPassenger1();
        passenger1.setName(passengerName1);
        passenger2 = newPassenger2();
        passenger2.setName(passengerName2);
        System.out.println("Car with passenger1 = " + passenger1.getName() +
                ", passenger2 = " + passenger2.getName());
    }
}
