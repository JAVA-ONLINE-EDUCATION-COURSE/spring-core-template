package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Репозиторий, основанный на классе ArrayList. initialSequence должен браться из
 * application.properties
 */
@Component
@PropertySource("classpath:application.properties")
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

  private ArrayList<Item> holder;

  @Value("${initial.sequence}")
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
    item.setId(initialSequence);
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
    this.holder = new ArrayList<>();
  }
}
