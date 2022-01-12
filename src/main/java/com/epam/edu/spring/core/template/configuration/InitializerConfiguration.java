package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class InitializerConfiguration {

    @Bean
    @Scope("prototype")
    @Lazy
    public Color colorFactory() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }


}
