package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
		ArrayListItemRepository arrayListItemRepository = (ArrayListItemRepository) ctx.getBean("arrayListItemRepository");
		LinkedListItemRepository linkedListItemRepository = (LinkedListItemRepository) ctx.getBean("linkedListItemRepository");
		ItemRepository itemRepository = (ItemRepository) ctx.getBean("itemRepository");
	}

}
