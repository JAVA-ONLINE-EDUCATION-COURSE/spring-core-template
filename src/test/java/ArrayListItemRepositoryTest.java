import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MainConfiguration.class})
@PropertySource("classpath.properties")
public class ArrayListItemRepositoryTest {

    @Value("${initial.sequence}")
    int val;

    Item itemTest1 = new Item(3, "toy", 50, new ColorFactory().getColor());
    Item itemTest2 = new Item(5, "toy", 50, new ColorFactory().getColor());

    @Autowired
    ArrayListItemRepository arrayListItemRepository;

    @Test
    public void getById() {
        arrayListItemRepository.createItem(itemTest2);
        assertEquals(itemTest2, arrayListItemRepository.getById(itemTest2.getId()));
    }

    @Test
    public void getByIdNull() {
        assertNull(arrayListItemRepository.getById(itemTest1.getId()));
    }

    @Test
    public void createItem() {
        boolean isItemCreated = arrayListItemRepository.createItem(itemTest1);
        assertTrue(isItemCreated);
    }

    @Test
    public void createItemShouldFalse() {
        arrayListItemRepository.createItem(itemTest1);
        assertFalse(arrayListItemRepository.createItem(itemTest1));
    }

    @Test
    public void setInitialSequence() {
        arrayListItemRepository.setInitialSequence(val);
        assertEquals(val, arrayListItemRepository.initialSequence);
    }

    @Test
    public void setHolder() {
        arrayListItemRepository.setHolder();
        assertEquals(new ArrayList<>(), arrayListItemRepository.holder);
    }

}
