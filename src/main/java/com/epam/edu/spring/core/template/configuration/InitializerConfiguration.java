package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.factory.ColorFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;



@ComponentScan
public class InitializerConfiguration {

    @Bean
    @Lazy
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ColorFactory colorFactory(){
        return new ColorFactory();
    }

}
