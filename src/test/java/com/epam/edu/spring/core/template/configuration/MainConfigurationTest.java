package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import junit.framework.TestCase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;




@ContextConfiguration(classes = MainConfiguration.class)
public class MainConfigurationTest extends TestCase {
    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(MainConfiguration.class);

    public void testItemRepository() {
        LinkedListItemRepository l = (LinkedListItemRepository) context.getBean("itemRepository");
        assertTrue(l.getInitialSequence()>0 && l.getInitialSequence()<100);
    }

    public void testItemService(){
        SimpleItemService s = (SimpleItemService) context.getBean("itemService");
        Item item1 = new Item(1, "Pasha", 20000000, Color.GREEN);
        Item item2 = new Item(2, "Masha", 10000000, Color.BLUE);
        Item item3 = new Item(3, "Dasha", 5000000, Color.YELLOW);
        Item item4 = new Item(1, "Pasha", 20000000, Color.GREEN);
        assertTrue(s.createItem(item1));
        assertTrue(s.createItem(item2));
        assertTrue(s.createItem(item3));
        assertFalse(s.createItem(item4));
        assertEquals(s.getById(2), item2);
        assertEquals(s.getById(4), null);
        System.out.println(s.getById(1));

    }
}