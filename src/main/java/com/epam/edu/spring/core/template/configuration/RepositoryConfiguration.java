package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public ItemRepository arrayListItemRepository() {
        return new ArrayListItemRepository(new ArrayList<>());
    }
}
