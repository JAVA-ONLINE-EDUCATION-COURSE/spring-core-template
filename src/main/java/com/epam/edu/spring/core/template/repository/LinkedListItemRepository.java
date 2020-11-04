package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {
   long initialSequence = new Random().nextInt(100);

    public LinkedListItemRepository(LinkedList<Item> listItem) {
        this.holder = listItem;
    }

    @Override
    public Item getById(long id) {
        for (Item item : holder) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        for (Item itemInList : holder) {
            if (itemInList.getId() == item.getId()) {
                return false;
            }
        }
        holder.add(item);
        return true;
    }

    void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    @Override
    public long getInitialSequence() {
        return initialSequence;
    }

    void setHolder() {
        this.holder = new LinkedList<>();
    }
}
