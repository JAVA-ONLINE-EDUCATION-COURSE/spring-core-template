package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {

    final InitializerConfiguration initializerConfiguration;
    final RepositoryConfiguration repositoryConfiguration;

    public MainConfiguration(InitializerConfiguration initializerConfiguration, RepositoryConfiguration repositoryConfiguration) {
        this.initializerConfiguration = initializerConfiguration;
        this.repositoryConfiguration = repositoryConfiguration;
    }

    @Value("${item.repository.implementation}")
    private String implementation;

    @Bean
    public ItemRepository itemRepository() {
        if (implementation.equals("array") || implementation.isEmpty()) {
            return repositoryConfiguration.arrayListItemRepository();
        } else {
            return repositoryConfiguration.linkedListItemRepository();
        }
    }

    @Bean
    public ItemValidator itemValidator() {
        return new SimpleItemValidator();
    }

    @Bean
    public ItemService itemService() {
        return new SimpleItemService(itemRepository(), itemValidator());
    }
}
