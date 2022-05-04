package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		Service service = context.getBean(Service.class);
	}

}
