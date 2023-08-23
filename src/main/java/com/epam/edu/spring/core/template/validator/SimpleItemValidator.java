package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class SimpleItemValidator implements ItemValidator {

  @Override
  public boolean isItemValid(Item item) {
    return item != null && item.getId() >= 0 && item.getName() != null && item.getPrice() > 0;
  }
}
