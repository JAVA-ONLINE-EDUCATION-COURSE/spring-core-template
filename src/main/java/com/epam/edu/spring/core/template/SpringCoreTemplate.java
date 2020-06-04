package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(MainConfiguration.class);

		MainConfiguration configuration = context.getBean(MainConfiguration.class);
		ItemRepository repository = configuration.repository();
		System.out.println(repository);

	}

}
