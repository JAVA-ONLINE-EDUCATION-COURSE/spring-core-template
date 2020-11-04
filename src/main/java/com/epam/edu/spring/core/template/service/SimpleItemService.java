package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleItemService implements ItemService {

    private ItemValidator itemValidator;
    private ItemRepository repository;

    @Autowired
    public SimpleItemService(ItemRepository repository, ItemValidator validator){
        this.repository=repository;
        this.itemValidator=validator;
    }

    @Autowired
    public void setItemValidator(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }

    @Override
    public Item getById(long id) {
        return repository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        if (itemValidator.isItemValid(item))
           return repository.createItem(item);
        return false;
    }
}
