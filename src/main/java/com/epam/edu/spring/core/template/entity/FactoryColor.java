package com.epam.edu.spring.core.template.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FactoryColor implements FactoryBean {
    public Color getColor() throws Exception {
        return getObject();
    }


    @Override
    public Color getObject() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

    @Override
    public Class<Color> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
