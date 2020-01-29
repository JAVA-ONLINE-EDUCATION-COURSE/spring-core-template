package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.ResourceBundle;

@Configuration
public class InitializerConfiguration {
    public static String listName;

    @Bean(initMethod = "initColors")
    public ColorFactory colorFact() {
        return new ColorFactory();
    }


    @Lazy
    @Resource
    @Bean
    public ItemRepository itemRepository(RepositoryConfiguration rep) {

        try {
            listName = ResourceBundle.getBundle("application").getString("item.repository.implementation");
        } catch (Exception e) {
            listName = "array";
        }

        if (listName.equals("linked")) {
            return new LinkedListItemRepository(rep.getList());
        } else {
            return new ArrayListItemRepository(rep.getList());
        }


    }


}
