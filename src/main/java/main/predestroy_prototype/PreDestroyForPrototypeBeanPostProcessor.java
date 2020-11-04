package main.predestroy_prototype;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

import javax.annotation.PreDestroy;
import java.lang.reflect.Method;

public class PreDestroyForPrototypeBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    /**
     * Before-обработка бинов. Если бин prototype, то определяем, известно ли о его destroy-методе.
     * При парсе с помощью XML-файла destroy-метод по умолчанию равен null, но можно указать явно с помощью атрибута тега.
     * При парсе с помощью ComponentScan destroy-метод равен null; без кастомной аннотации в BeanDefinition нельзя передать
     * информацию о destroy-методе.
     * При парсе с помощью JavaConfig destroy-метод по умолчанию равен (inferred) (строка). Можно указать явно, передав
     * название метода в соответствующий параметр в @Bean.
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\t* Before. Бин: " + beanName + ", класс: " + bean.getClass().getSimpleName());
        AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) factory.getBeanDefinition(beanName);
        if (beanDefinition.isPrototype()) {
            System.out.println("\t  Init-метод:    " + beanDefinition.getInitMethodName());
            System.out.println("\t  Destroy-метод: " + beanDefinition.getDestroyMethodName());
            if (beanDefinition.getDestroyMethodName() != null) {
                printWarning(beanName);
                return bean;
            }
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PreDestroy.class)) {
                    System.out.println("\t  Ищем метод с аннотацией PreDestroy =_=");
                    printWarning(beanName);
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\t* After.  Бин: " + beanName + ", класс: " + bean.getClass().getSimpleName());
        return bean;
    }

    private void printWarning(String beanName) {
        System.out.println("\t! WARNING: Destroy-метод у бина " + beanName + " не будет вызван, т.к. он prototype!");
    }
}
