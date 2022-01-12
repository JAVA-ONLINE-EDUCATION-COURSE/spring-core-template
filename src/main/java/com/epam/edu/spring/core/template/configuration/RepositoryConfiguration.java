package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {

    @Value("${item.repository.implementation}")
    String itemRepositoryImplementationType;

    @Bean
    public ArrayListItemRepository arrayListItemRepository() {
        return new ArrayListItemRepository();
    }

    @Bean
    public LinkedListItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository();
    }

    @Bean
    public ItemRepository itemRepository() {
        if (itemRepositoryImplementationType.equals("linked")) {
            return linkedListItemRepository();
        } else {
            return arrayListItemRepository();
        }
    }
}
