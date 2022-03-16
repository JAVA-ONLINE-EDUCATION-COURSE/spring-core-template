package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Repository
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {


    @Override
    public Item getById(long id) {
        if(!holder.isEmpty()) {
        for(Item item : holder) {
            if(item.getId() == id) {
                return item;
               }
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        if(!(holder.isEmpty())) {
                for (Item el : holder) {
                    if (el.getId() == item.getId()) {
                        return false;
                    }
                }
                }
            holder.add(item);
            return true;

        }

    @Value("${initial.sequence}")
    void setInitialSequence(int val) {
        initialSequence = val;
    }
   @PostConstruct
    void setHolder() {
        this.holder = new ArrayList<>();
    }
}
