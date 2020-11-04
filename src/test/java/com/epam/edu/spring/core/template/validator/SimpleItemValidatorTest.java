package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import junit.framework.TestCase;

public class SimpleItemValidatorTest extends TestCase {

    public void testIsItemValid() {
        SimpleItemValidator s = new SimpleItemValidator();
        Item item = new Item(1, "Pasha", 20000000, Color.GREEN);
        assertTrue(s.isItemValid(item));
        Item item2 = new Item(1, "Pasha", 60000000, Color.GREEN);
        assertFalse(s.isItemValid(item2));
        Item item3 = new Item(1, "Pasha Ogorodnikov", 20000000, Color.GREEN);
        assertFalse(s.isItemValid(item3));
    }
}