package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;


import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public LinkedListItemRepository(LinkedList<Item> itemLinkedList) {
        this.itemLinkedList = itemLinkedList;
    }

    private LinkedList<Item> itemLinkedList;
    int initialSequence;

    @Override
    public Item getById(long id) {
        for (Item i : itemLinkedList) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        return itemLinkedList.add(item);
    }


    public void setInitialSequence(int val) {
        Random random = new Random(val);
        this.initialSequence = random.nextInt(100);
    }


    void setHolder() {
        holder = this.itemLinkedList;
    }
}
