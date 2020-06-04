package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Component
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private final ArrayList<Item> listItem;

    private ListIterator<Item> listIterator;

    @Autowired
    public ArrayListItemRepository(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    @Override
    public Item getById(long id) {
        for (Item item : listItem) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        for (Item itemInList : listItem) {
            if (itemInList.equals(item)) {
                return false;
            }
        }
        listItem.add(item);
        return true;
    }

    void setInitialSequence(@Value("${initial.sequence}") int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.listIterator = listItem.listIterator();
    }
}
