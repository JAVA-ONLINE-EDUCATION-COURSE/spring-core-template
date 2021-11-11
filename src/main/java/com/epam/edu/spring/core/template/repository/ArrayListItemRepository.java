package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public ArrayListItemRepository(List<Item> itemArrayList) {
        this.holder = itemArrayList;
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

    void setInitialSequence(@Value("${initial.sequence}")int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.holder = new ArrayList<>();
    }
}
