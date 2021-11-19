package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

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
        holder = new LinkedList<>();
    }

    public LinkedListItemRepository(int initialSequence) {
        setHolder();
        setInitialSequence(initialSequence);
    }
}
