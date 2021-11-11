package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public LinkedListItemRepository(List<Item> itemLinkedList) {
        this.holder = itemLinkedList;
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
        if (holder.contains(item)) {
            return false;
        } else {
            return holder.add(item);
        }
    }

    public void setInitialSequence(int val) {
        Random random = new Random();
        this.initialSequence = random.nextInt(100);
    }

    public void setHolder() {
        this.holder = new LinkedList<>();
    }
}
