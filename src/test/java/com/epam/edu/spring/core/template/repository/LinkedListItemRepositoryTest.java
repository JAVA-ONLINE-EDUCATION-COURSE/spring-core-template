package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.LinkedList;

public class LinkedListItemRepositoryTest extends TestCase {

    LinkedListItemRepository l = new LinkedListItemRepository(new LinkedList<>());
    Item item = new Item(1, "Pasha", 20000000, Color.GREEN);
    Item item2 = new Item(2, "Masha", 10000000, Color.YELLOW);

   @Before
   public void setUp(){
       l.createItem(item);
       l.createItem(item2);
   }


    public void testGetById() {
        assertEquals(l.getById(1).getName(), "Pasha");
        assertEquals(l.getById(2).getColor(), Color.YELLOW);
    }

    public void testCreateItem() {
        Item item3 = new Item(2, "Sasha", 5000, Color.BLUE);
        assertFalse(l.createItem(item3));

        Item item4 = new Item(3, "Sasha", 5000, Color.BLUE);
        assertTrue(l.createItem(item4));
    }
}