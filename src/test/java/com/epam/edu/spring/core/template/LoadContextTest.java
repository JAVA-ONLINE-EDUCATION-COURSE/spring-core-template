package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.ColorFactory;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MainConfiguration.class)
public class LoadContextTest {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void itemValidatorCreateTest() {
        ItemValidator itemValidator = ctx.getBean(ItemValidator.class);
        Assert.assertNotNull(itemValidator);
    }

    @Test
    public void itemServiceConstructorCreateTest() {
        SimpleItemService itemServiceConstructor = (SimpleItemService) ctx.getBean("itemServiceConstructor");
        Assert.assertNotNull(itemServiceConstructor);
    }

    @Test
    public void itemServiceSetterCreateTest() {
        SimpleItemService itemServiceSetter = (SimpleItemService) ctx.getBean("itemServiceSetter");
        Assert.assertNotNull(itemServiceSetter);
    }

    @Test
    public void linkedListItemRepositoryCreateTest() {
        LinkedListItemRepository linkedListItemRepository = ctx.getBean(LinkedListItemRepository.class);
        Assert.assertNotNull(linkedListItemRepository);
    }

    @Test
    public void arrayListItemRepositoryCreateTest() {
        ArrayListItemRepository arrayListItemRepository = ctx.getBean(ArrayListItemRepository.class);
        Assert.assertNotNull(arrayListItemRepository);
    }

    @Test
    public void colorFactoryCreateTest() {
        ColorFactory colorFactory = ctx.getBean(ColorFactory.class);
        Assert.assertNotNull(colorFactory);
    }

}
