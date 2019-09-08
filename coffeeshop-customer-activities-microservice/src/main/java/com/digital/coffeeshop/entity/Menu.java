package com.digital.coffeeshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Menu database table.
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    public Menu(int menuId, String menuName, Date createdDate, Date alteredDate, int shopId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.createdDate = createdDate;
        this.alteredDate = alteredDate;
        this.shopId = shopId;
    }

    public Menu() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "altered_date")
    private Date alteredDate;

    @Column(name = "shop_id")
    private int shopId;

    @OneToMany(mappedBy = "menu")
    private List<Item> items = new ArrayList<>();

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", createdDate=" + createdDate +
                ", alteredDate=" + alteredDate +
                ", shopId=" + shopId +
                ", items=" + items +
                '}';
    }
}
