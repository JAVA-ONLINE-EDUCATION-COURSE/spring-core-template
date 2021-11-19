package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MainConfiguration.class })
@PropertySource("classpath:application.properties")
public class TestLinkedListItemRepository {

    @Autowired
    LinkedListItemRepository linkedListItemRepository;

    private final Item testItem1 = new Item(1, "bicycle", 100, new ColorFactory().getColor());
    private final Item testItem2 = new Item(2, "t-shirt", 120, new ColorFactory().getColor());

    @Test
    public void testGetById() {
        linkedListItemRepository.createItem(testItem1);
        linkedListItemRepository.createItem(testItem2);

        assertEquals(testItem1.getId(), linkedListItemRepository.getById(testItem1.getId()).getId());
        assertEquals(testItem2.getId(), linkedListItemRepository.getById(testItem2.getId()).getId());
    }

    @Test
    public void testGetByIdShouldEqualsNull() {
        linkedListItemRepository.createItem(testItem1);

        assertNull(linkedListItemRepository.getById(-1));
    }

    @Test
    public void testGetByIdShouldReturnFalse() {
        linkedListItemRepository.createItem(testItem1);
        linkedListItemRepository.createItem(testItem2);

        assertNotEquals(testItem1.getId(), linkedListItemRepository.getById(5));
    }

    @Test
    public void testCreateItem() {
        assertTrue(linkedListItemRepository.createItem(testItem1));
    }

    @Test
    public void testCreateItemShouldReturnFalse() {
        linkedListItemRepository.createItem(testItem1);
        assertFalse(linkedListItemRepository.createItem(testItem1));
    }
}
