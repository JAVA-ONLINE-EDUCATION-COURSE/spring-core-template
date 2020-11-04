package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Item;

public class SimpleItemValidator implements ItemValidator {

    //допустим нельзя создовать имена с пробелами
    // и price имеет ограничения в 5 000 000
    @Override
    public boolean isItemValid(Item item) {
        return !item.getName().contains(" ") && !(item.getPrice() > 50000000);
    }
}
