package com.epam.edu.spring.core.template;


import com.epam.edu.spring.core.template.configuration.InitializerConfiguration;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.configuration.RepositoryConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MainConfiguration.class })
public class TestMainInitializerConfiguration {
    @Autowired
    InitializerConfiguration initializerConfiguration;

    @Autowired
    RepositoryConfiguration repositoryConfiguration;

    @Autowired
    MainConfiguration mainConfiguration;

    @Test
    public void testInitializeRepository() {
        ItemRepository itemRepository = repositoryConfiguration.itemRepository();
        assertNotNull(itemRepository);
    }

    @Test
    public void testInitializeService() {
        ItemService itemService = mainConfiguration.simpleItemService();
        assertNotNull(itemService);
    }

    @Test
    public void testColorFactory() {
        ColorFactory colorFactory = initializerConfiguration.colorFactory();
        assertNotNull(colorFactory);
    }
}

