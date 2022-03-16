package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.InitializerConfiguration;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args)  {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

		ColorFactory colorFactory = context.getBean(ColorFactory.class);
		System.out.println(colorFactory.getColor());
		SimpleItemService simpleItemService = context.getBean(SimpleItemService.class);
		simpleItemService.createItem(new Item(1, "itemOne", 22, colorFactory.getColor()));
		System.out.println(simpleItemService.getById(1));


		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}

}
