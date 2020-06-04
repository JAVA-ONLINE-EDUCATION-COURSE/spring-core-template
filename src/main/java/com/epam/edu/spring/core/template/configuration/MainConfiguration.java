package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.epam.edu.spring.core.template")
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {

    @Value("${item.repository.implementation}")
    String implementation;

    @Autowired
    private RepositoryConfiguration repositoryConfiguration;

    @Autowired
    private InitializerConfiguration initializerConfiguration;

    @Bean
    public ItemRepository repository() {
        if (implementation.equals("array")) {
            return  repositoryConfiguration.arrayListItemRepository();
        } else if (implementation.equals("linked")) {
            return  repositoryConfiguration.linkedListItemRepository();
        } else {
            return repositoryConfiguration.arrayListItemRepository();
        }
    }

    @Bean
    public Color getColor() throws Exception {
        return initializerConfiguration.getColor();
    }
}
