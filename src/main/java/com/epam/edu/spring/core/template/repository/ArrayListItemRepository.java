package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        return holder.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean createItem(Item item) {
        if (item == null) {
            return false;
        }
        return holder.add(item);
    }

    public ArrayListItemRepository(int val) {
        setInitialSequence(val);
        setHolder();
    }
    void setInitialSequence(int val) {
        //TODO
        initialSequence = val;
    }

    void setHolder() {
        //TODO
        holder = new ArrayList<Item>();
    }
}
