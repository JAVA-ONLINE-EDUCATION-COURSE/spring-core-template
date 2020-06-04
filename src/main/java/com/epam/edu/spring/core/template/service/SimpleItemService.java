package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class SimpleItemService implements ItemService {

    private final ItemService itemService;

    private final ItemValidator itemValidator;

    @Autowired
    public SimpleItemService(ItemService itemService, ItemValidator itemValidator) {
        this.itemService = itemService;
        this.itemValidator = itemValidator;
    }

    @Override
    public Item getById(long id) {
        return itemService.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        return itemValidator.isItemValid(item);
    }
}
