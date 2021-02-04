package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */

@PropertySource(value = "classpath:application.properties")
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {
    public ArrayListItemRepository(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    private ArrayList<Item> itemArrayList;


    private int initialSequence;

    @Override
    public Item getById(long id) {
        for (Item i : itemArrayList) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        return itemArrayList.add(item);
    }

    @Override
    @Value(value = "${initial.sequence}")
    void setInitialSequence(int val) {
        this.initialSequence = val;
    }


    @Override
    void setHolder() {
        holder = this.itemArrayList;
    }

}