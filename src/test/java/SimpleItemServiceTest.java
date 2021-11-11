import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainConfiguration.class})
public class SimpleItemServiceTest {

    @Autowired
    SimpleItemService simpleItemService;

    Item itemTest = new Item(3, "toy", 50, new ColorFactory().getColor());
    Item itemTest2 = new Item(6, "toy", 50, new ColorFactory().getColor());

    @Test
    public void getById() {
        simpleItemService.createItem(itemTest2);
        assertEquals(itemTest2, simpleItemService.getById(6));
    }

    @Test
    public void getByIdNull() {
        Item item = new Item(10, "toy", 50, new ColorFactory().getColor());
        assertNull(simpleItemService.getById(item.getId()));
    }

    @Test
    public void createItem() {
        Item itemTest = new Item(3, "toy", 50, new ColorFactory().getColor());
        boolean isItemCreated = simpleItemService.createItem(itemTest);

        assertTrue(isItemCreated);
    }
}
