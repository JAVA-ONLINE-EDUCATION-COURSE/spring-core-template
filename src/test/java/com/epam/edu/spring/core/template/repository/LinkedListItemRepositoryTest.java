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
public class LinkedListItemRepositoryTest {

    private static Item itemOne;
    private static Item itemTwo;


    @Autowired
    LinkedListItemRepository linkedListItemRepository;

    @BeforeEach
    private void createObjectOneTwo() {
        itemOne = new Item(254, "test item 1", 12.32, Color.ORANGE);
        itemTwo = new Item(255, "test item 2", 25.61, Color.YELLOW);
        linkedListItemRepository.setHolder();
    }
    @Test
    @DisplayName("test method setHolder()")
    void testSetHolder() {
        Assertions.assertNotNull(linkedListItemRepository.holder);
    }
    @Test
    @DisplayName("test method setInitialSequence(int val) ")
    void testSetInitialSequence() {
        Assertions.assertNotEquals(0, linkedListItemRepository.initialSequence);
    }
    @Test
    @DisplayName("test method getById(long id)")
    void testGetById() {
        linkedListItemRepository.createItem(itemOne);
        Assertions.assertEquals(linkedListItemRepository.getById(254), itemOne);
    }
    @Test
    @DisplayName("test method createItem(Item item)")
    void testCreateItem() {
        Assertions.assertTrue(linkedListItemRepository.createItem(itemTwo));
    }

}
