package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.ArrayList;


public class RepositoryConfiguration {
    private static ArrayList<Item> list = new ArrayList<>();

    public void addToList(Item item) {
        list.add(item);
    }

    public ArrayList<Item> getList() {
        return list;
    }

}
