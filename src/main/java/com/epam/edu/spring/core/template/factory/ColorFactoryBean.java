package com.epam.edu.spring.core.template.factory;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Stream;

@Component
public class ColorFactoryBean implements FactoryBean<Color> {

  private final Random random = new Random();

  @Override
  public Color getObject() {
    return Stream.of(Color.values())
        .filter(color -> color.ordinal() == random.nextInt(Color.values().length))
        .findAny()
        .orElseThrow(IllegalStateException::new);
  }

  @Override
  public Class<?> getObjectType() {
    return Color.class;
  }

  @Override
  public boolean isSingleton() {
    return FactoryBean.super.isSingleton();
  }
}
