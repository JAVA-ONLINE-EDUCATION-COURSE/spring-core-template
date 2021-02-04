package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;


import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringCoreTemplate {



	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
		ApplicationContext applicationContext = annotationConfigApplicationContext;
		applicationContext.getBean(SimpleItemValidator.class);


	}

}
