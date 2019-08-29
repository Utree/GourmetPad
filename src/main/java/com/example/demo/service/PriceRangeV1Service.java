package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.PriceRangeV1;
import com.example.demo.repository.PriceRangeV1Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceRangeV1Service {
    @Autowired
    private PriceRangeV1Repository priceRangeV1Repository;

    public List<PriceRangeV1> findAll() {
        return priceRangeV1Repository.findAll();
    }

    public PriceRangeV1 findById(Long id) {
        return priceRangeV1Repository.findById(id).orElse(null);
    }

    public PriceRangeV1 findByName(String name) {
        return priceRangeV1Repository.findByName(name).get(0);
    }

    public PriceRangeV1 findByAscOrder(Integer ascOrder) {
        return priceRangeV1Repository.findByAscOrder(ascOrder).get(0);
    }
}