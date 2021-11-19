package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.ColorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class InitializerConfiguration {

    @Lazy
    @Bean
    @Scope("prototype")
    public ColorFactory colorFactory() {
        return new ColorFactory();
    }

}
