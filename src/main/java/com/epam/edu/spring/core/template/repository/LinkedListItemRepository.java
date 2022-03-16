package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.LinkedList;


/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
@Repository
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        for(Item item : holder) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    @Override
    public boolean createItem(Item item) {
        if(!holder.isEmpty()) {
            for(Item createItem : holder) {
                if(createItem.getId() == item.getId()) {
                    return false;
                }
            }
        }
        holder.add(item);
        return true;
    }
    @Value(value = "#{ T(java.lang.Math).random() * 100 + 1 }")
   public void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    @PostConstruct
    void setHolder() {
       this.holder = new LinkedList<>();
    }
}
