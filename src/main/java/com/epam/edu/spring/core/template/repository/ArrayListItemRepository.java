package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Component
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private ArrayList<Item> listItem = new ArrayList<>();

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
        //TODO
    }

    public ArrayList<Item> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }


}
