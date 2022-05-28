package com.epam.edu.spring.core.template.entity;

import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

public class ColorFactory implements FactoryBean<Color> {

    Random rnd = new Random(System.currentTimeMillis());

    public Color getColor() throws Exception {
        return getObject();
    }

    public Color getObject() throws Exception {
        return Color.values()[rnd.nextInt(Color.values().length)];
    }

    public Class<Color> getObjectType() {
        return Color.class;
    }

    public boolean isSingleton() {
        return false;
    }
}

