package main.predestroy_prototype;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        System.out.println("\t~ Обработка BeanDefinition:");
        for (int i = 0; i < factory.getBeanDefinitionNames().length; i++) {
            System.out.println("\t" + (i + 1) + ".\t" + factory.getBeanDefinitionNames()[i]);
        }
    }
}
