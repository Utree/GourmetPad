package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String priceRange;
    @NotEmpty
    private String place;

    public Shop() {}

    public Shop(String name, String priceRange, String place) {
        this.name = name;
        this.priceRange = priceRange;
        this.place = place;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPriceRange() { return priceRange; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", priceRange=" + priceRange + ", place=" + place + "]";
    }
}