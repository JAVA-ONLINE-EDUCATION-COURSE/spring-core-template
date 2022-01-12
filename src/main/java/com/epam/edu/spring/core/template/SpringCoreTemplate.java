package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfiguration.class);

        ItemRepository itemService = context.getBean("itemRepository", ItemRepository.class);

        Item item1 = new Item(1, "Car", 100, context.getBean("colorFactory", Color.class));
        Item item2 = new Item(2, "Bus", 200, context.getBean("colorFactory", Color.class));
        Item item3 = new Item(3, "Airplane", 2000, context.getBean("colorFactory", Color.class));

        itemService.createItem(item1);
        itemService.createItem(item2);
        itemService.createItem(item3);

        System.out.println(itemService.getById(1) + " initialSequence: " + itemService.getInitialSequence());
        System.out.println(itemService.getById(2) + " initialSequence: " + itemService.getInitialSequence());
        System.out.println(itemService.getById(3) + " initialSequence: " + itemService.getInitialSequence());
    }
}
