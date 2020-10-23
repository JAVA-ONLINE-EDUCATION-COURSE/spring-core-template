package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    private ItemRepository itemRepository;

    @Bean
    public ArrayListItemRepository arrayListItemRepository() {
        return new ArrayListItemRepository();
    }

    @Bean
    public LinkedListItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository();
    }

    @Value("${item.repository.implementation}")
    private void initConfiguration (String implementation) {
        if (implementation.equals("linked")) {
            itemRepository = linkedListItemRepository();
        } else {
            itemRepository = arrayListItemRepository();
        }
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

}
