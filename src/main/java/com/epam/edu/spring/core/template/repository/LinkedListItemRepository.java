package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Репозиторий, основанный на классе LinkedList. initialSequence должен случайно генерироваться из
 * диапазона от 1 до 100
 */
@Component
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

  private LinkedList<Item> holder;

  @Value("#{T(java.lang.Math).random() * 100.0 }")
  int initialSequence;

  @Override
  public Item getById(long id) {
    if (holder.stream().filter(item -> item.getId() == id).count() > 1) {
      throw new IllegalStateException("More than 1 element found");
    }
    return holder.stream().filter(item -> item.getId() == id).collect(Collectors.toList()).get(0);
  }

  @Override
  public boolean createItem(Item item) {
    return holder.add(Objects.requireNonNull(item));
  }

  @Override
  void setInitialSequence(int val) {
    this.initialSequence += val;
  }

  public int getInitialSequence() {
    return this.initialSequence;
  }

  @Override
  void setHolder() {
    this.holder = new LinkedList<>();
  }
}
