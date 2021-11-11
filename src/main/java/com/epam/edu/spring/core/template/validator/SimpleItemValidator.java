package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Item;

public class SimpleItemValidator implements ItemValidator {

    @Override
    public boolean isItemValid(Item item) {
        return item != null;
    }
}
