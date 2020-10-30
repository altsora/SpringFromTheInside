package main.example1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class RandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    public RandomIntAnnotationBeanPostProcessor() {
        System.out.println("+ Конструктор " + this.getClass().getSimpleName());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\t* Before. Бин: " + beanName + ", класс: " + bean.getClass());
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field : fields) {
            if (field.isAnnotationPresent(RandomInt.class)) {
                RandomInt annotation = field.getAnnotation(RandomInt.class);
                int randomInt = getRandomInt(annotation.min(), annotation.max());
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomInt);
                System.out.println("\t\tВнедряем случайное значение age: " + randomInt);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\t* After. Бин: " + beanName + ", класс: " + bean.getClass());
        return bean;
    }

    private int getRandomInt(int min, int max) {
        return min + new Random().nextInt(max - min);
    }
}
