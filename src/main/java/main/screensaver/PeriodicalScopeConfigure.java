package main.screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.now;

public class PeriodicalScopeConfigure implements Scope {
    private Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String beanName, ObjectFactory<?> objectFactory) {
        if (map.containsKey(beanName)) {
            Pair<LocalTime, Object> pair = map.get(beanName);
            int secondsSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
            if (secondsSinceLastRequest > 3) {
                map.put(beanName, new Pair<>(now(), objectFactory.getObject()));
            }
        } else {
            map.put(beanName, new Pair<>(now(), objectFactory.getObject()));
        }

        return map.get(beanName).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
