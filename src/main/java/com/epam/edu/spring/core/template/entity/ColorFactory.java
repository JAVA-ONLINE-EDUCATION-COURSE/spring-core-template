package com.epam.edu.spring.core.template.entity;

import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

public class ColorFactory implements FactoryBean<Color> {

    Random random = new Random();

    public Color getColor() {
        return getObject();
    }

    @Override
    public Color getObject() {
        return Color.values()[random.nextInt(Color.values().length)];
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
