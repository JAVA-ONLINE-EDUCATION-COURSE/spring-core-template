package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {
    private ArrayList<Item> items;
    private ListIterator<Item> iterator;

    public ArrayList<Item> getList() {
        return items;
    }

    public ArrayListItemRepository(List<Item> items) {
        this.items = (ArrayList<Item>) items;
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
