package com.epam.edu.spring.core.template.tests;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("linked")
@SpringJUnitConfig(MainConfiguration.class)
public class LinkedListRepositoryTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private LinkedListItemRepository linkedListItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("Тест присваивания itemRepository переменной типа ArrayListItemRepository, если свойство item.repository.implementation=array")
    public void integrationTestShouldCreateLinkedListItemRepositoryIfImplementaionIsLinked(){

        assertEquals(linkedListItemRepository, itemRepository);
    }


}