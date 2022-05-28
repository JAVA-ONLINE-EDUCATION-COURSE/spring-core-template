package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Item;

public class SimpleItemValidator implements ItemValidator {

    @Override
    public boolean isItemValid(Item item) {
        if (item != null && item.getId() > 0 && item.getName() != null && item.getPrice() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
