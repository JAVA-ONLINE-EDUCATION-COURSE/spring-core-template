package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        return holder.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean createItem(Item item) {
        if (item == null) {
            return false;
        }
        return holder.add(item);
    }

    public LinkedListItemRepository(int val) {
        setInitialSequence(val);
        setHolder();
    }

    void setInitialSequence(int val) {
        //TODO
        initialSequence = val;
    }

    @PostConstruct
    void setHolder() {
        //TODO
        holder = new LinkedList<Item>();
    }
}
