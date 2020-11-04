package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {

    @Value("${item.repository.implementation}")
    String implementation;

    @Autowired
    RepositoryConfiguration repositoryConfiguration;
    @Autowired
    InitializerConfiguration initializerConfiguration;

    @Bean
    public ItemRepository itemRepository() {
        if (implementation.equals("linked")) {
            return repositoryConfiguration.linkedListItemRepository();
        }
        return repositoryConfiguration.arrayListItemRepository();
    }

    @Bean
    public ItemValidator itemValidator(){
        return new SimpleItemValidator();
    }

    @Bean
    public ItemService itemService(){
        return new SimpleItemService(itemRepository(), itemValidator());
    }
}
