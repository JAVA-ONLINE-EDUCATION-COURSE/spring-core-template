package com.epam.edu.spring.core.template.service;


import com.epam.edu.spring.core.template.ItemService;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MainConfiguration.class)
public class SimpleItemServiceTest {
    public static Item itemOne;
    public static Item itemTwo;
    public static Item itemThree;

    @Autowired
    ItemService itemService;

    @BeforeEach
    private void createObjectOneTwo() {
        itemOne = new Item(554, "itemOne", 222.22, Color.WHITE);
        itemTwo = new Item(82, "itemTwo", 17.56, Color.BLACK);
        itemThree = new Item(81, "itemThree", 18.00, Color.ORANGE);

    }
    @Test
    @DisplayName("test method getById(long id)")
    void testGetById() {
        itemService.createItem(itemOne);
        Assertions.assertEquals(itemService.getById(554), itemOne);
    }

    @Test
    @DisplayName("test method createItem(Item item)")
    void testCreateItem() {
        Assertions.assertTrue(itemService.createItem(itemTwo));
    }

    @Test
    @DisplayName("test method createItem(Item item)")
        void itemCouldNotBeCreated() {
        itemService.createItem(itemThree);
        Assertions.assertFalse(itemService.createItem(itemThree));
    }

}
