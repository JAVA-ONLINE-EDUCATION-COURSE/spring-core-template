package com.epam.edu.spring.core.template.configuration;


import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InitializerConfiguration.class, RepositoryConfiguration.class})
public class MainConfiguration {

    @Autowired
    ItemRepository itemRepository;
}
