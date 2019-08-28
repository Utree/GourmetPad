package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ShopV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @ManyToOne
    private PriceRangeV1 priceRange;
    @NotEmpty
    private String place;
    @NotNull
    @ManyToOne
    private CategoryV1 category;

    public ShopV2() {}

    public ShopV2(String name, PriceRangeV1 priceRange, String place, CategoryV1 category) {
        this.name = name;
        this.priceRange = priceRange;
        this.place = place;
        this.category = category;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public PriceRangeV1 getPriceRange() { return priceRange; }
    public void setPriceRange(PriceRangeV1 priceRange) { this.priceRange = priceRange; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public CategoryV1 getCategory() { return category; }
    public void setCategory(CategoryV1 category) { this.category = category; }

    @Override
    public String toString() {
        return "ShopV2 [category=" + category + ", id=" + id + ", name=" + name + ", place=" + place + ", priceRange="
                + priceRange + "]";
    }
}