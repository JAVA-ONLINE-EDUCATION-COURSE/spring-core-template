package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.annotation.InjectRandomInt;
import com.epam.edu.spring.core.template.configuration.ColorFactory;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;

public class SimpleItemService implements ItemService {
    ItemRepository repository;
    ColorFactory colorFactory;
    int id = -1;
    @InjectRandomInt(min = 10, max = 1000)
    int price;

    public SimpleItemService(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    public Item getAndCreateNewItem() {
        id++;
        return new Item(id, "Item", price, colorFactory.getColors().get(id));
    }

    @Override
    public Item getById(long id) {
        return repository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        return false;
    }
}
