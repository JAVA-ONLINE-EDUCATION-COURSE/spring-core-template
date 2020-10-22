package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MainConfiguration.class)
public class BusinessLogicTest {

    @Autowired
    private ArrayListItemRepository arrayListItemRepository;
    @Autowired
    private LinkedListItemRepository linkedListItemRepository;

    @Autowired
    ApplicationContext ctx;

    @Test
    public void createItemTest1() {
        Item item = new Item(0,"item", 200, null);
        arrayListItemRepository.createItem(item);
        Assert.assertEquals(item, arrayListItemRepository.getById(42));
    }

    @Test
    public void createItemTest2() {
        Item item = new Item(0,"NewItem", 200, null);
        arrayListItemRepository.createItem(item);
        Assert.assertNotEquals(item, arrayListItemRepository.getById(42));
        Assert.assertEquals(item, arrayListItemRepository.getById(43));
    }

    @Test
    public void addedTwoItemLinkedListTest() {
        Item itemOne = new Item(0,"itemOne", 2000000001, null);
        Item itemTwo = new Item(0,"itemTwo", 200, null);
        Assert.assertTrue(linkedListItemRepository.createItem(itemOne));
        Assert.assertTrue(linkedListItemRepository.createItem(itemTwo));
    }

}
