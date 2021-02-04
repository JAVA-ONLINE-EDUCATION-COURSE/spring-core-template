package template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.FactoryColor;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.AbstractRepository;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MainConfiguration.class)

public class TestApplication {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
    Item itemTest = new Item(1, "ItemTest", 16.5, Color.BLACK);

    @Test
    public void testFactoryColor() throws Exception {
        Assert.assertNotNull("Color не создался", annotationConfigApplicationContext.getBean(FactoryColor.class).getColor());
        Assert.assertNotSame("Color не является цветом", annotationConfigApplicationContext.getBean(FactoryColor.class).getColor().getClass(), Enum.class);
    }

    @Test
    public void testArrayListItemRepository() throws Exception {
        ArrayListItemRepository arrayListItemRepositoryTest = (ArrayListItemRepository) annotationConfigApplicationContext.getBean("arrayListItemRepository");
        Assert.assertTrue("Объект не добавлен в ArrayListItemRepository", arrayListItemRepositoryTest.createItem(itemTest));
        Assert.assertEquals("Объект не существует или не найден в ArrayListItemRepository", arrayListItemRepositoryTest.getById(1), itemTest);
        Field initialSequence = arrayListItemRepositoryTest.getClass().getDeclaredField("initialSequence");
        initialSequence.setAccessible(true);
        int initialSequenceValue = (int) initialSequence.get(arrayListItemRepositoryTest);
        Assert.assertEquals("InitialSequence не считывается из проперти", 42, initialSequenceValue);
    }

    @Test
    public void testLinkedListItemRepository() throws Exception {
        LinkedListItemRepository linkedListItemRepositoryTest = (LinkedListItemRepository) annotationConfigApplicationContext.getBean("linkedListItemRepository");
        Assert.assertTrue("объект не добавлен в LinkedListItemRepository", linkedListItemRepositoryTest.createItem(itemTest));
        Assert.assertEquals("Объект не существует или не найден в LinkedListItemRepository", linkedListItemRepositoryTest.getById(1), itemTest);
        linkedListItemRepositoryTest.setInitialSequence(15);
        Field initialSequence = linkedListItemRepositoryTest.getClass().getDeclaredField("initialSequence");
        initialSequence.setAccessible(true);
        int initialSequenceValue = (int) initialSequence.get(linkedListItemRepositoryTest);
        Assert.assertTrue("InitialSequence превосходит допустимое значение", initialSequenceValue <= 100);
    }

    @Test
    public void testSimpleItemsService() {
        SimpleItemService service = annotationConfigApplicationContext.getBean(SimpleItemService.class);
        Assert.assertTrue("Объект не создан", service.createItem(itemTest));
        Assert.assertEquals("У вас не правильно выбирается ItemRepository исходя из проперти", ArrayListItemRepository.class, service.getItemRepository().getClass());
        Assert.assertEquals("Объект не существует или не найден в ItemRepository", service.getById(1), itemTest);
    }

    @Test
    public void testSimpleItemValidator() {
        SimpleItemValidator simpleItemValidator = annotationConfigApplicationContext.getBean(SimpleItemValidator.class);
        Assert.assertTrue("Объекта не существует", simpleItemValidator.isItemValid(itemTest));
    }
}
