package com.epam.edu.spring.core.template;


import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MainConfiguration.class })
@PropertySource("classpath:application.properties")
public class TestArrayListItemRepository {

    @Value("${initial.sequence}")
    private String initialSequence;

    @Autowired
    ArrayListItemRepository arrayListItemRepository;

    private final Item testItem1 = new Item(1, "bicycle", 100, new ColorFactory().getColor());
    private final Item testItem2 = new Item(2, "t-shirt", 120, new ColorFactory().getColor());

    @Test
    public void testGetById() {
        arrayListItemRepository.createItem(testItem1);
        arrayListItemRepository.createItem(testItem2);

        assertEquals(testItem1.getId(), arrayListItemRepository.getById(testItem1.getId()).getId());
        assertEquals(testItem2.getId(), arrayListItemRepository.getById(testItem2.getId()).getId());
    }

    @Test
    public void testGetByIdShouldEqualsNull() {
        arrayListItemRepository.createItem(testItem1);

        assertNull(arrayListItemRepository.getById(-1));
    }


    @Test
    public void testGetByIdShouldReturnFalse() {
        arrayListItemRepository.createItem(testItem1);
        arrayListItemRepository.createItem(testItem2);

        assertNotEquals(testItem1.getId(), arrayListItemRepository.getById(5));
    }

    @Test
    public void testCreateItem() {
        assertTrue(arrayListItemRepository.createItem(testItem1));
    }

    @Test
    public void testCreateItemShouldReturnFalse() {
        arrayListItemRepository.createItem(testItem1);
        assertFalse(arrayListItemRepository.createItem(testItem1));
    }
}
