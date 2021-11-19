package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        return (Item) holder.stream().filter(el -> el.getId() == (id + initialSequence));
    }

    @Override
    public boolean createItem(Item item) {

        item.setId(item.getId() + initialSequence);
        return holder.add(item);

    }

    void setInitialSequence(int val) {
        initialSequence = val;
    }

    void setHolder() {
        holder = new ArrayList<>();
    }

    public ArrayListItemRepository(int initialSequence) {
        setHolder();
        setInitialSequence(initialSequence);
    }
}
