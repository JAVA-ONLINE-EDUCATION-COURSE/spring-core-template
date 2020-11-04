package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringCoreTemplate {

	public static void main(String[] args) {
		System.out.println("hello word");

		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(MainConfiguration.class);

		//ArrayListItemRepository a = (ArrayListItemRepository) context.getBean("itemRepository");
		LinkedListItemRepository l = (LinkedListItemRepository) context.getBean("itemRepository");

		Item item = new Item(1, "Pasha", 20000000, Color.GREEN);
		l.createItem(item);
		Item pasha = l.getById(1);

		System.out.println(pasha);

		Item item2 = new Item(2, "Masha", 10000000, Color.YELLOW);

		context.close();

	}
}
