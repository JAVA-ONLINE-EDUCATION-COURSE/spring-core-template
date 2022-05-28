package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class InitializerConfiguration {

    @Bean("ColorFactory")
    @Lazy
    @Scope("prototype")
    public ColorFactory colorFactory() {
        return new ColorFactory();
    }

//    @Bean("Color")
//
//    public Color color() throws Exception {
//        return colorFactory().getObject();
//    }
}
