package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MainConfiguration.class)
public class SpringCoreTemplateTest {

    @Value("${initial.sequence}")
    int itemRepositoryImplementation;

    @Value("${item.repository.implementation}")
    String repositoryImplementation;

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
    Item item1 = new Item(1, "item1", 10.2, Color.Indigo);
    Item item2 = new Item(2, "item2", 15.2, Color.Blue);
    Item item3 = new Item(3, "item3", 0.2, Color.Orange);

    @Test
    public void contextNotNullTest() {
        assertNotNull(context);
    }

    @Test
    public void colorFactoryTest() {
        assertNotNull(context.getBean("colorFactory", Color.class));
    }

    @Test
    public void arrayListItemRepository_BeanCreatedTest() {
        assertNotNull(context.getBean("arrayListItemRepository", ItemRepository.class));
    }

    @Test
    public void linkedListItemRepository_BeanCreatedTest() {
        assertNotNull(context.getBean("linkedListItemRepository", ItemRepository.class));
    }

    @Test
    public void itemRepository_BeanCreatedTest() {
        assertNotNull(context.getBean("itemRepository", ItemRepository.class));
    }

    @Test
    public void itemRepository_addtoList() {
        ItemRepository itemService = context.getBean("itemRepository", ItemRepository.class);

        itemService.createItem(item1);
        itemService.createItem(item2);
        itemService.createItem(item3);

        assertEquals(itemService.getById(1), item1);
    }

    @Test
    public void createItem_Test() {
        ItemRepository itemService = context.getBean("itemRepository", ItemRepository.class);
        assertTrue(itemService.createItem(item1));
    }


    @Test
    public void readProp_Test() {
        ItemRepository itemRepository = context.getBean("arrayListItemRepository", ItemRepository.class);

        if (itemRepository instanceof ArrayListItemRepository) {
            assertEquals(itemRepository.getInitialSequence(), itemRepositoryImplementation);
        } else {
            assertNotEquals(itemRepository.getInitialSequence(), itemRepositoryImplementation);
        }
    }

    @Test
    public void readPropRepositoryImpl_Test() {
        ItemRepository itemRepository = context.getBean("itemRepository", ItemRepository.class);

        if (repositoryImplementation.equals("linked")) {
            assertTrue(itemRepository instanceof LinkedListItemRepository);
        } else {
            assertTrue(itemRepository instanceof ArrayListItemRepository);
        }
    }


}