package com.digital.coffeeshop.model;

public class _Item {
    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "_Item{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
