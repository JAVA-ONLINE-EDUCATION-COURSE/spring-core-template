package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.annotation.InjectRandomInt;
import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {
    private LinkedList<Item> items;
    private ListIterator<Item> iterator;
    @InjectRandomInt(min = 0, max = 100)
    private int initialSequence;

    public LinkedListItemRepository(List<Item> items) {
        this.items = (LinkedList<Item>) items;
    }

    public LinkedList<Item> getList() {
        return items;
    }

    @Override
    public Item getById(long id) {
        return (Item) items.stream().filter(item -> item.getId() == id);
    }

    @Override
    public boolean createItem(Item item) {
        return items.add(item);
    }

    void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.iterator = items.listIterator();
    }
}
