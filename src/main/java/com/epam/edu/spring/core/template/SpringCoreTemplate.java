package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import com.epam.edu.spring.core.template.service.ItemService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
		ArrayListItemRepository arrayListItemRepository = (ArrayListItemRepository) ctx.getBean("arrayListItemRepository");
		LinkedListItemRepository linkedListItemRepository = (LinkedListItemRepository) ctx.getBean("linkedListItemRepository");
		ItemRepository itemRepository = (ItemRepository) ctx.getBean("itemRepository");
		ItemService itemService = (ItemService) ctx.getBean("simpleItemService");

		ColorFactory colorFactory = ctx.getBean(ColorFactory.class);
//		System.out.println(colorFactory.getColor());
//		System.out.println(ctx.getBean("colorFactory"));


		Item item = new Item(1, "bicycle", 100, colorFactory.getColor());
		Item item1 = new Item(2, "t-shirt", 120, colorFactory.getColor());
		itemService.createItem(item);
		itemService.createItem(item1);
		System.out.println(itemService.getById(item.getId()).getId());
		System.out.println(itemService.getById(item1.getId()));

	}
}
