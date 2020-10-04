package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Component
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

   // private final ArrayList<Item> listItem;

    @Autowired
    public ArrayListItemRepository(ArrayList<Item> listItem) {
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
            if (itemInList.equals(item)) {
                return false;
            }
        }
        holder.add(item);
        return true;
    }

    void setInitialSequence(int val) {
        this.initialSequence=val;
    }
    long getInitialSequence() {
        return this.initialSequence;
    }

    void setHolder() {
        this.holder = new ArrayList<>();
    }
}
