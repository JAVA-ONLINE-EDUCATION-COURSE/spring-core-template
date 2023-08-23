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

  @Autowired
  public SimpleItemService(ItemRepository itemRepository, ItemValidator itemValidator) {
    this.itemRepository = itemRepository;
    this.itemValidator = itemValidator;
  }

  @Override
  public Item getById(long id) {
    return null;
  }

  @Override
  public boolean createItem(Item item) {
    return false;
  }

  public void setItemRepository(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public void setItemRepository(ItemValidator itemValidator) {
    this.itemValidator = itemValidator;
  }

}
