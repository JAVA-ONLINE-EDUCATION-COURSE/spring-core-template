package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;

public class SimpleItemService implements ItemService {


    private ItemRepository itemRepository;
    private ItemValidator itemValidator;

    public SimpleItemService(ItemRepository itemRepository, ItemValidator itemValidator) {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void setItemValidator(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        return itemValidator.isItemValid(item) && itemRepository.createItem(item);
    }
}
