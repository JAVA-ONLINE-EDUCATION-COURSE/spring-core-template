package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleItemService implements ItemService {

    private ItemRepository itemRepository;
    private ItemValidator itemValidator;
    @Autowired
    public SimpleItemService(ItemRepository itemRepository, ItemValidator itemValidator) {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;
    }


    public void setItemValidator(ItemValidator itemValidator) {
        this.itemValidator = itemValidator;
    }

    public SimpleItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        if(itemValidator.isItemValid(item)) {
            return itemRepository.createItem(item);
        }
        return false;
    }
}
