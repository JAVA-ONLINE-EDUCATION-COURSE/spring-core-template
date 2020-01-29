package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
        ItemRepository repository = ctx.getBean(ItemRepository.class);
        System.out.println("All items:");
        for (Item item : repository.getList()) {
            System.out.println(item.getName() + " " + item.getColor() + " " + item.getPrice());
        }
        double absoluteCost = 0;
        for (Item item : repository.getList()) {
            absoluteCost += item.getPrice();
        }
        System.out.println("\nTotal cost: " + absoluteCost);
    }

}
