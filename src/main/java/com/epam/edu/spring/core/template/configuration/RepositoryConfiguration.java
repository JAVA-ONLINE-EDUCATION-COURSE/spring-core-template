package com.epam.edu.spring.core.template.configuration;


import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.ItemService;
import com.epam.edu.spring.core.template.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {

    @Value("${item.repository.implementation}")
    String implementation;

    @Bean
    public ItemRepository itemRepository() {
        return implementation.equals("array") ? arrayListItemRepository() : linkedListItemRepository();
    }
    @Bean
    public ArrayListItemRepository arrayListItemRepository() {
    return new ArrayListItemRepository();
}
    @Bean
    public LinkedListItemRepository linkedListItemRepository() {
    return new LinkedListItemRepository();
}
    @Bean
    public ItemService itemService() {
        return new SimpleItemService(itemRepository(), itemValidator());
    }
    @Bean
    public ItemValidator itemValidator() {
        return new SimpleItemValidator();
    }
}
