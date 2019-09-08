package com.digital.coffeeshop.model;

import java.util.List;

public class _CoffeeShop {

    private int coffeeShopId;
    private String coffeeShopName;
    private String coffeeShopDescription;
    private List<_Location> _locations;

    public int getCoffeeShopId() {
        return coffeeShopId;
    }

    public void setCoffeeShopId(int coffeeShopId) {
        this.coffeeShopId = coffeeShopId;
    }

    public String getCoffeeShopName() {
        return coffeeShopName;
    }

    public void setCoffeeShopName(String coffeeShopName) {
        this.coffeeShopName = coffeeShopName;
    }

    public String getCoffeeShopDescription() {
        return coffeeShopDescription;
    }

    public void setCoffeeShopDescription(String coffeeShopDescription) {
        this.coffeeShopDescription = coffeeShopDescription;
    }

    public List<_Location> get_locations() {
        return _locations;
    }

    public void set_locations(List<_Location> _locations) {
        this._locations = _locations;
    }

    @Override
    public String toString() {
        return "_CoffeeShop{" +
                "coffeeShopId=" + coffeeShopId +
                ", coffeeShopName='" + coffeeShopName + '\'' +
                ", coffeeShopDescription='" + coffeeShopDescription + '\'' +
                ", _locations=" + _locations +
                '}';
    }
}
