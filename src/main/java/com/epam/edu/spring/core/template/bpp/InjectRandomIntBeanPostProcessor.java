package com.epam.edu.spring.core.template.bpp;

import com.epam.edu.spring.core.template.annotation.InjectRandomInt;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();

                Random rnd = new Random();
                int randomValue = min + rnd.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomValue);

            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return null;
    }

}
