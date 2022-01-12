package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private final ArrayList<Item> itemArrayList = new ArrayList<>();

    @Value("${initial.sequence}")
    private long initialSequence = super.initialSequence;


    @Override
    public Item getById(long id) {
        for (Item item : itemArrayList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        return itemArrayList.add(item);
    }


    void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        holder = itemArrayList;
    }

    public long getInitialSequence() {
        return initialSequence;
    }

}
