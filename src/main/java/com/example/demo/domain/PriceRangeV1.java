package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Entity
public class PriceRangeV1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @Min(0)
    private Integer ascOrder;

    public PriceRangeV1() {}

    public PriceRangeV1(String name, Integer ascOrder) {
        this.name = name;
        this.ascOrder = ascOrder;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getOrder() { return ascOrder; }
    public void setOrder(Integer ascOrder) { this.ascOrder = ascOrder; }

    @Override
    public String toString() {
        return "PriceRangeV1 [id=" + id + ", name=" + name + ", ascOrder=" + ascOrder + "]";
    }

    
}