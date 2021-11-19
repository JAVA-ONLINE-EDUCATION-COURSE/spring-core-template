package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleItemService implements ItemService {

    private ItemRepository itemRepository;
    private ItemValidator itemValidator;

    public SimpleItemService() {

    }

    @Autowired
    public SimpleItemService(ItemRepository itemRepository, ItemValidator itemValidator) {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        if (itemValidator.isItemValid(item)) {
            return itemRepository.createItem(item);
        }
        return false;
    }

    @Autowired
    public void setItemValidator(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}
