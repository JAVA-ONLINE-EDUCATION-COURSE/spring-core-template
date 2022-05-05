package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private final LinkedList<Item> itemLinkedList = new LinkedList<>();

    private long initialSequence = new Random().nextLong();

    @Override
    public Item getById(long id) {
        for (Item item : itemLinkedList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        return itemLinkedList.add(item);
    }

    void setInitialSequence(int val) {
        initialSequence = val;
    }

    void setHolder() {
        holder = this.itemLinkedList;
    }

    public long getInitialSequence() {
        return initialSequence;
    }
}
