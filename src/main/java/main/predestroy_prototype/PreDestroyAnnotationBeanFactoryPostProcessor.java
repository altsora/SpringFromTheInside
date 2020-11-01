package main.predestroy_prototype;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.Method;

public class PreDestroyAnnotationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * Обработка собственной аннотации @PreDestroyClass над классом, которая в качестве параметра принимает
     * имя метода, который должен стать destroy-методом.
     * <p>
     * В зависимости от способа парса конфигурации (XML, JavaConfig или ComponentScan) в BeanDefinition либо будет информация
     * о классе бина, либо нет. В XML класс явно указывается при объявлении бина и, соответственно, его можно получить;
     * при @Component класс тоже можно получить. А вот при создании бина через @Bean информация о классе недоступна сразу,
     * поэтому стоит try-catch конструкция.
     *
     * @see PreDestroyClass
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        System.out.println(" ~ Созданные BeanDefinition (их имена):");
        for (int i = 0; i < factory.getBeanDefinitionNames().length; i++) {
            System.out.println("\t" + (i + 1) + ".\t" + factory.getBeanDefinitionNames()[i]);
        }
        System.out.println(" ~ Ищем классы, помеченные @PreDestroyClass");
        String[] beanDefinitionNames = factory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanDefinitionName);
            System.out.println("\tBean: " + beanDefinitionName);
            try {
                Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
                System.out.println("\t\t+ Есть данные о классе: " + beanClass);
                if (beanClass.isAnnotationPresent(PreDestroyClass.class)) {
                    System.out.println("\t\t  Найдена аннотация PreDestroyClass над " + beanClass);
                    PreDestroyClass annotation = beanClass.getAnnotation(PreDestroyClass.class);
                    Method destroyMethod = beanClass.getMethod(annotation.destroyMethod());
                    beanDefinition.setDestroyMethodName(destroyMethod.getName());
                }
            } catch (ClassNotFoundException | NullPointerException e) {
                System.out.println("\t\t- Нет данных о классе для бина " + beanDefinitionName +
                        ", т.к. бин создаётся через JavaConfig, а там до создания бина " +
                        "нельзя узнать про класс бина");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
