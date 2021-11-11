package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.service.ColorFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfiguration.class);


		ColorFactory colorFactory1 = context.getBean("colorFactory", ColorFactory.class);

		System.out.println(colorFactory1.getColor());

		//colorFactory1.getColor(Color.BLUE);


	}

}
