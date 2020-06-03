package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.context.annotation.*;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Scope("singleton")
    public ItemRepository arrayListItemRepository() {
        return new ArrayListItemRepository();
    }

    @Bean
    @Scope("singleton")
    public ItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository();
    }

}
