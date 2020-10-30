package main.selfautowired;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class SelfAutowiredAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field : fields) {
            if (field.isAnnotationPresent(SelfAutowired.class)) {
                map.put(beanName, bean);
                break;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object originalBean = map.get(beanName);
        if (originalBean != null) {
            Field[] fields = originalBean.getClass().getDeclaredFields();
            for(Field field : fields) {
                if (field.isAnnotationPresent(SelfAutowired.class)) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, originalBean, bean);
                }
            }
        }
        return bean;
    }
}
