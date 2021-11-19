package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.service.ColorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class InitializerConfiguration {

    @Bean
    @Scope("prototype")
    public ColorFactory colorFactory() {
        return new ColorFactory();
    }

}
