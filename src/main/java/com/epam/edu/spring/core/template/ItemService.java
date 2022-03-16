package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.entity.Item;

public interface ItemService {

    Item getById(long id);

    boolean createItem(Item item);

}
