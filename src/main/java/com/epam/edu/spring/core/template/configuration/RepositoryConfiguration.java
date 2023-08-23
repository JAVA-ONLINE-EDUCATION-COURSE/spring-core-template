package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {

  @Bean
  public ItemRepository itemRepository(
      @Value("${item.repository.implementation}") String repository) {
    ItemRepository itemRepository;
    if ("link".equalsIgnoreCase(repository)) {
      itemRepository = new LinkedListItemRepository();
    } else {
      itemRepository = new ArrayListItemRepository();
    }
    return itemRepository;
  }
}
