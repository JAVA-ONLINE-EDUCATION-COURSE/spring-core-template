package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		System.out.println("hello word");

		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(MainConfiguration.class);

		ArrayListItemRepository a = (ArrayListItemRepository) context.getBean("arrayListItemRepository");
		Item item = new Item(1, "Pasha", 20000000, Color.GREEN);
		a.createItem(item);
		Item pasha = a.getById(1);
		System.out.println(pasha);

		context.close();

	//	System.out.println(context);

	}
}
