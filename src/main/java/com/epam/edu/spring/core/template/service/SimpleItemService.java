package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SimpleItemService implements ItemService {

    private ItemRepository itemRepository;

    private ItemValidator itemValidator;

    @Autowired
    public SimpleItemService(ItemRepository itemRepository, ItemValidator itemValidator) {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    public void setItemValidator(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }


    @Override
    public Item getById(long id) {return itemRepository.getById(id);
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    @Override
    public boolean createItem(Item item) {
        return itemRepository.createItem(item);
    }


}
