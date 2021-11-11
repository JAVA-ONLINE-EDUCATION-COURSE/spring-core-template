import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainConfiguration.class})
public class LinkedListItemRepositoryTest {

    @Autowired
    LinkedListItemRepository linkedListItemRepository;

    Item itemTest = new Item(3, "toy", 50, new ColorFactory().getColor());
    Item itemTest2 = new Item(4, "toy", 50, new ColorFactory().getColor());

    @Test
    public void getById() {
        linkedListItemRepository.createItem(itemTest2);
        assertEquals(itemTest2, linkedListItemRepository.getById(itemTest2.getId()));
    }

    @Test
    public void getByIdNull() {
        assertNull(linkedListItemRepository.getById(itemTest2.getId()));
    }

    @Test
    public void createItem() {
        assertTrue(linkedListItemRepository.createItem(itemTest));
    }

    @Test
    public void createItemShouldFalse() {
        Item testCreatedItem = itemTest;

        linkedListItemRepository.createItem(testCreatedItem);
        assertFalse(linkedListItemRepository.createItem(testCreatedItem));
    }

    @Test
    public void setInitialSequence() {
        linkedListItemRepository.setInitialSequence(0);
        assertTrue(100 >= linkedListItemRepository.initialSequence &&
                linkedListItemRepository.initialSequence >= 0);
    }

    @Test
    public void setHolder() {
        linkedListItemRepository.setHolder();
        assertEquals(new LinkedList<>(), linkedListItemRepository.holder);
    }
}
