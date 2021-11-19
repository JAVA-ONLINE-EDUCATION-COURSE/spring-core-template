package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MainConfiguration.class })
@PropertySource("classpath:application.properties")
public class TestSimpleItemService {

    @Autowired
    ItemService simpleItemService;

    private final Item item = new Item(10, "spaceShip", 10, new ColorFactory().getColor());

    @Test
    public void testGetById() {
        simpleItemService.createItem(item);

        assertEquals(item.getId(), simpleItemService.getById(item.getId()).getId());
    }

    @Test
    public void testGetByIdShouldEqualsNull() {
        simpleItemService.createItem(item);

        assertNull(simpleItemService.getById(-1));
    }

    @Test
    public void testCreateItem() {

        assertTrue(simpleItemService.createItem(item));
    }

    @Test
    public void testCreateItemShouldReturnFalse() {
        simpleItemService.createItem(item);
        assertFalse(simpleItemService.createItem(item));
    }
}
