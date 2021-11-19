package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Repository
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        return holder.stream().filter(el -> el.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean createItem(Item item) {

        if (holder.contains(item)) return false;

        item.setId(item.getId() + initialSequence);
        return holder.add(item);

    }

    public void setInitialSequence(int val) {
        initialSequence = val;
    }

    public void setHolder() {
        holder = new ArrayList<>();
    }

    public ArrayListItemRepository(int initialSequence) {
        setHolder();
        setInitialSequence(initialSequence);
    }
}
