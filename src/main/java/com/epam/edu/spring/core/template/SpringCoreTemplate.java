package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		ColorFactory factory = context.getBean("factoryBean", ColorFactory.class);

	}

}
