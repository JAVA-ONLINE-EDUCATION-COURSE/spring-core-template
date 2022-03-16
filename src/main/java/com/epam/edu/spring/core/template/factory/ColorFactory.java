package com.epam.edu.spring.core.template.factory;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.FactoryBean;

import java.util.Random;


public class ColorFactory implements FactoryBean<Color> {

    @Override
    public Color getObject() {
        Color[] colors = Color.values();
        return colors[new Random().nextInt(colors.length)];
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

   public Color getColor()  {
        return getObject();
   }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
