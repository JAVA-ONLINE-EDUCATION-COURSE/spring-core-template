package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfiguration.class);

		ColorFactory colorFactory = context.getBean(ColorFactory.class);
		ItemService itemService = context.getBean("itemService", ItemService.class);

		Item item1 = new Item(1, "table", 100, colorFactory.getColor());
		Item item2 = new Item(2, "chair", 111, colorFactory.getColor());

		itemService.createItem(item1);
		itemService.createItem(item2);

		System.out.println(itemService.getById(item1.getId()));
		System.out.println(itemService.getById(item2.getId()));
	}

}
