package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */

@PropertySource("classpath:application.properties")
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {


    @Override
    public Item getById(long id) {
        return holder.stream().filter(o -> (o.getId() == id)).findFirst().orElse(null);
    }

    @Override
    public boolean createItem(Item item) {
        item.setId(initialSequence);
        holder.add(item);
        initialSequence++;
        return true;
    }

    @Value("${initial.sequence}")
    @Override
    void setInitialSequence(int val) {
        initialSequence = val;
    }

    @PostConstruct
    void setHolder() {
        holder = new ArrayList<>();
    }

}
