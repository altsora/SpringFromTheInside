package main.example1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class HandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Autowired
    private Color color;

    public HandlerBeanFactoryPostProcessor() {
        System.out.println("+ Конструктор " + this.getClass().getSimpleName());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Внедрение зависимости в BeanFactoryPostProcessor: color = " + color);
        System.out.println("Созданные BeanDefinition: ");
        for (int i = 0; i < beanFactory.getBeanDefinitionNames().length; i++) {
            System.out.println("\t" + (i + 1) + ".\t" + beanFactory.getBeanDefinitionNames()[i]);
        }
    }
}
