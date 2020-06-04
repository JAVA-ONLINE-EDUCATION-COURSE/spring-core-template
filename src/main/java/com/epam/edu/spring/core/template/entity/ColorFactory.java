package com.epam.edu.spring.core.template.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class ColorFactory implements FactoryBean<Color> {

    private int factoryId;
    private int colorId;

    @Override
    public Color getObject() throws Exception {
        Random random = new Random();
        int randomNumber = random.ints(0, Color.values().length)
                .limit(1)
                .findFirst()
                .getAsInt();

        Color[] colors = Color.values();
        return colors[randomNumber];
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
