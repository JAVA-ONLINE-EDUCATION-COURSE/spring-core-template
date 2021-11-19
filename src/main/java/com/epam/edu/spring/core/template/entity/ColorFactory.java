package com.epam.edu.spring.core.template.entity;


import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ColorFactory extends AbstractFactoryBean<Color> {

    public ColorFactory() {
        setSingleton(false);
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    protected Color createInstance() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

    public Color getColor() {
        return createInstance();
    }
}
