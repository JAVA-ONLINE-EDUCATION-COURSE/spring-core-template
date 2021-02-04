package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import java.util.ArrayList;
import java.util.LinkedList;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class RepositoryConfiguration {
    @Value(value = "${item.repository.implementation}")
    String implementationType;

    @Bean
    public ItemRepository itemRepository() {
        if (implementationType.equals("linked")) {
            return linkedListItemRepository();
        } else {
            return arrayListItemRepository();
        }
    }

    @Bean
    public LinkedListItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository(new LinkedList<>());
    }

    @Bean
    public ArrayListItemRepository arrayListItemRepository() {
        return new ArrayListItemRepository(new ArrayList<>());
    }
}

