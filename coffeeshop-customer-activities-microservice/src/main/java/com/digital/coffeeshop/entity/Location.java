package com.digital.coffeeshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the Location database table.
 */
@Entity
@Table(name = "location")
public class Location implements Serializable {
    public Location() {
    }

    public Location(int locationId, Date createdDate, Date alteredDate, String address, double longitude, double latitude, CoffeeShop coffeeShop) {
        this.locationId = locationId;
        this.createdDate = createdDate;
        this.alteredDate = alteredDate;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.coffeeShop = coffeeShop;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "altered_date")
    private Date alteredDate;

    @Column(name = "address")
    private String address;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private CoffeeShop coffeeShop;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", createdDate=" + createdDate +
                ", alteredDate=" + alteredDate +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", coffeeShop=" + coffeeShop +
                '}';
    }
}
