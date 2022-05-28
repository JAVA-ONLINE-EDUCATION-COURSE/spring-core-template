package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import com.epam.edu.spring.core.template.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {

    @Value("${initial.sequence}")
    Integer initialSequence;

    Random rnd = new Random(System.currentTimeMillis());
    @Bean
    ArrayListItemRepository arrayListItemRepository() {
        return new ArrayListItemRepository(initialSequence);
    }

    @Bean
    LinkedListItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository(rnd.nextInt(100) + 1);
    }

    @Value("${item.repository.implementation}")
    String repositoryImplementation;

    @Bean
    ItemRepository itemRepository() {
        if (repositoryImplementation == null || !repositoryImplementation.equals("linked")) {
            return new ArrayListItemRepository(initialSequence);
        } else {
            return new LinkedListItemRepository(rnd.nextInt(100) + 1);
        }
    }

    @Bean
    ItemValidator itemValidator() {
        return new SimpleItemValidator();
    }

    @Bean
    SimpleItemService simpleItemService() {
        return new SimpleItemService();
    }
}
