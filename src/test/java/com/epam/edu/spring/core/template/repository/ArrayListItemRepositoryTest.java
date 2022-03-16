package com.epam.edu.spring.core.template.repository;

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
public class ArrayListItemRepositoryTest {

    @Autowired
    ArrayListItemRepository arrayListItemRepository;

    public static Item itemOne;
    public static Item itemTwo;

   @BeforeEach
    public void createObjectOneTwo() {
        itemOne = new Item(154, "ObjectOne", 8.15, Color.BLACK);
        itemTwo = new Item(155, "ObjectTwo", 15.02, Color.WHITE);
        arrayListItemRepository.setHolder();
    }

    @Test
    @DisplayName("test method setHolder()")
    void testSetHolder() {
        Assertions.assertNotNull(arrayListItemRepository.holder);
    }
    @Test
    @DisplayName("test method getById(long id)")
    void testGetById() {
        arrayListItemRepository.createItem(itemOne);
        Assertions.assertEquals(arrayListItemRepository.getById(154), itemOne);
    }
    @Test
    @DisplayName("test method createItem(Item item)")
    void testCreateItem() {
        Assertions.assertTrue(arrayListItemRepository.createItem(itemTwo));
    }
    @Test
    @DisplayName("test method setInitialSequence(int val) ")
    void testSetInitialSequence() {
        Assertions.assertNotEquals(0, arrayListItemRepository.initialSequence);
    }

}
