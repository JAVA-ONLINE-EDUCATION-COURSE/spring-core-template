package com.epam.edu.spring.core.template.configuration;


import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@Import({InitializerConfiguration.class, RepositoryConfiguration.class})
public class MainConfiguration {

    @Autowired
    ItemRepository itemRepository;

    @Bean
    ItemValidator simpleItemValidator() {
        return new SimpleItemValidator();
    }

    @Bean
    public ItemService simpleItemService() {
        SimpleItemService itemService = new SimpleItemService();
        itemService.setItemValidator(simpleItemValidator());
        itemService.setItemRepository(itemRepository);
        return itemService;
    }

}
