package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Item;

public class SimpleItemValidator implements ItemValidator {

    @Override
    public boolean isItemValid(Item item) {
        return isIdValid(item)&&isPriceValid(item)&&isNameValid(item);
    }

    private boolean isIdValid(Item item) {
        if (item.getId() < 0) {
            System.err.println("id must be positive");
            return false;
        }
        return true;
    }

    private boolean isPriceValid(Item item) {
        if (item.getPrice() < 0) {
            System.err.println("Price must be positive.");
            return false;
        }
        return true;
    }

    private boolean isNameValid(Item item) {
        String itemName = item.getName();
        if (itemName == null || itemName.isEmpty()) {
            System.err.println("name is empty.");
            return false;
        }
        return true;
    }
}
