package com.digital.coffeeshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the CoffeeShop database table.
 */

@Entity
@Table(name = "coffee_Shop")
public class CoffeeShop implements Serializable {
    public CoffeeShop() {
    }

    public CoffeeShop(int coffeeShopId, Date createdDate, Date alteredDate, String coffeeShopName, String coffeeShopDescription) {
        this.coffeeShopId = coffeeShopId;
        this.createdDate = createdDate;
        this.alteredDate = alteredDate;
        this.coffeeShopName = coffeeShopName;
        this.coffeeShopDescription = coffeeShopDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int coffeeShopId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "altered_date")
    private Date alteredDate;

    @Column(name = "coffee_shop_name")
    private String coffeeShopName;

    @Column(name = "coffee_shop_description")
    private String coffeeShopDescription;

    @OneToMany(mappedBy = "coffeeShop")
    private List<Location> locations = new ArrayList<>();

    public int getCoffeeShopId() {
        return coffeeShopId;
    }

    public void setCoffeeShopId(int coffeeShopId) {
        this.coffeeShopId = coffeeShopId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getAlteredDate() {
        return alteredDate;
    }

    public void setAlteredDate(Date alteredDate) {
        this.alteredDate = alteredDate;
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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
