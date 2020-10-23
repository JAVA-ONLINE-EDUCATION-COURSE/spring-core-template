package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.ColorFactory;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);

		ItemValidator itemValidator = ctx.getBean(ItemValidator.class);
		SimpleItemService itemServiceConstructor = (SimpleItemService) ctx.getBean("itemServiceConstructor");
		SimpleItemService itemServiceSetter = (SimpleItemService) ctx.getBean("itemServiceSetter");

		LinkedListItemRepository linkedListItemRepository = ctx.getBean(LinkedListItemRepository.class);
		ArrayListItemRepository arrayListItemRepository = ctx.getBean(ArrayListItemRepository.class);

		ColorFactory colorFactory = ctx.getBean(ColorFactory.class);
	}

}
