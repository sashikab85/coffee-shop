package com.digital.coffeeshop.model;

import java.util.List;

public class _Menu {

    private String name;
    private List<_Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<_Item> getItems() {
        return items;
    }

    public void setItems(List<_Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "_Menu{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
