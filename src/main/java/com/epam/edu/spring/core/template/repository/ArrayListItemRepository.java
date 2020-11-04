package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

   // private final ArrayList<Item> listItem;
   @Value("${initial.sequence}")
   public long initialSequence;

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
            if (itemInList.getId() == item.getId()) {
                return false;
            }
        }
        holder.add(item);
        return true;
    }

    void setInitialSequence(int val) {
        this.initialSequence=val;
    }


    void setHolder() {
        this.holder = new ArrayList<>();
    }
}
