package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.bpp.InjectRandomIntBeanPostProcessor;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;

@Configuration
@Import({InitializerConfiguration.class, InjectRandomIntBeanPostProcessor.class})
public class MainConfiguration {

    @Resource
    @Bean
    public SimpleItemService simpleItemService(ColorFactory colorFactory) {
        return new SimpleItemService(colorFactory);
    }

    @Lazy
    @Bean
    @Scope(scopeName = "prototype")
    public Item item(SimpleItemService simpleItemService) {
        return simpleItemService.getAndCreateNewItem();
    }

    @Bean
    public RepositoryConfiguration repositoryConfiguration(SimpleItemService simpleItemService, ColorFactory colorFactory) {
        RepositoryConfiguration repositoryConfiguration = new RepositoryConfiguration();
        boolean colorIsOver = false;

        while (!colorIsOver) {
            try {
                repositoryConfiguration.addToList(simpleItemService.getAndCreateNewItem());
            } catch (Exception e) {
                colorIsOver = true;
            }


        }
        return repositoryConfiguration;

    }

}
