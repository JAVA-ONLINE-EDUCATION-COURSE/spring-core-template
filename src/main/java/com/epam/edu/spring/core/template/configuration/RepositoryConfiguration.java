package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {
    @Value("${initial.sequence}")
    private Integer initialSequence;

    private final Random random = new Random();

    @Value("${item.repository.implementation}")
    private String repositoryImplementation;


    @Bean
    ArrayListItemRepository arrayListItemRepository() {
        return  new ArrayListItemRepository(getSequence());
    }

    @Bean
    LinkedListItemRepository linkedListItemRepository() {
        return  new LinkedListItemRepository(random.nextInt(100) + 1);
    }

    @Bean
    public ItemRepository itemRepository() {
        if (repositoryImplementation.equals("array")) {
            return arrayListItemRepository();
        }
        else if(repositoryImplementation.equals("linked")) {
            return linkedListItemRepository();
        }
        return arrayListItemRepository();
    }

    private Integer getSequence() {
        return initialSequence != null ? initialSequence : 0;
    }
}
