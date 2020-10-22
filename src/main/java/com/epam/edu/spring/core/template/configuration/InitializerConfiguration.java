package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;
import java.util.Objects;

@Configuration
public class InitializerConfiguration implements FactoryBean<ColorFactory> {

    @Override
    public ColorFactory getObject() {
        return new ColorFactory();
    }

    @Override
    public Class<?> getObjectType() {
        return ColorFactory.class;
    }

    public Color getColor() throws Exception {
        return Objects.requireNonNull(getObject()).getColor();
    }

}

