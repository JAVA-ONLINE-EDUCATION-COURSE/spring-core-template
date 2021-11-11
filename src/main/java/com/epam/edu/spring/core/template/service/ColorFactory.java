package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

public class ColorFactory implements FactoryBean<Color> {
    Random random = new Random();

    public String getColor() {
        //Color.values()[random.nextInt(Color.values().length)]
        return "color";
    }

    @Override
    public Color getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
