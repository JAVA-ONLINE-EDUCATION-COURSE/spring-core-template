package com.epam.edu.spring.core.template.entity;

import org.springframework.beans.factory.FactoryBean;
import java.util.Random;


public class ColorFactory implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

    @Override
    public Class<?> getObjectType() {
        return ColorFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public Color getColor(){
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

}
