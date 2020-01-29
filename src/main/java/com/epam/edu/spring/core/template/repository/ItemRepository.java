package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.List;

public interface ItemRepository {

    Item getById(long id);

    boolean createItem(Item item);

    List<Item> getList();
}
