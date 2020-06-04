package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LinkedListItemRepository.class)
public class LinkedListItemRepositoryTest {

    @Autowired
    private LinkedListItemRepository itemRepository;
    
    private static Item apple;
    private static Item orange;

    @Before
    public void setUp() throws Exception {
        apple = new Item(1, "apple", 1000, new ColorFactory().getObject());
        orange = new Item(2, "orange", 2000, new ColorFactory().getObject());
    }

    public LinkedListItemRepositoryTest() throws Exception {
    }

    @Test
    public void testCreateItemLinkedList() throws Exception {

        boolean createAppleBoolean = itemRepository.createItem(apple);
        boolean createOrangeBoolean = itemRepository.createItem(orange);
        boolean repeatCreateAppleBoolean= itemRepository.createItem(apple);

        assertThat(createAppleBoolean, equalTo(true));
        assertThat(createOrangeBoolean, equalTo(true));
        assertThat(repeatCreateAppleBoolean, equalTo(false));
    }

    @Test
    public void testGetByIdLinkedList() throws Exception {

        itemRepository.createItem(apple);
        itemRepository.createItem(orange);
        itemRepository.createItem(apple);

        Item findApple = itemRepository.getById(1);
        Item findOrange = itemRepository.getById(2);
        Item notFind = itemRepository.getById(3);

        assertThat(apple, equalTo(findApple));
        assertThat(orange, equalTo(findOrange));
        assertThat(null, equalTo(notFind));
    }
}