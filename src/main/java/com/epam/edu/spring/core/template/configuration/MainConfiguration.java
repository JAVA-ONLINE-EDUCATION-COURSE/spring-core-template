package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.InjectRandomIntAnnotationBeanPostProcessor;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Import({ InitializerConfiguration.class, RepositoryConfiguration.class, InjectRandomIntAnnotationBeanPostProcessor.class})
public class MainConfiguration {

    @Bean
    public ItemValidator itemValidator() {
        return new SimpleItemValidator();
    }

    @Bean
    @Qualifier("itemServiceConstructor")
    public SimpleItemService itemServiceConstructor(RepositoryConfiguration repositoryConfiguration) {
        return new SimpleItemService(repositoryConfiguration.getItemRepository(),itemValidator());
    }

    @Bean
    public SimpleItemService itemServiceSetter(RepositoryConfiguration repositoryConfiguration) {
        SimpleItemService simpleItemService = new SimpleItemService();
        simpleItemService.setItemRepository(repositoryConfiguration.getItemRepository());
        simpleItemService.setItemValidator(itemValidator());
        return simpleItemService;
    }

}

