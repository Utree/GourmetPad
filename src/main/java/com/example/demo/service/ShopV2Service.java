package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.ShopV2;
import com.example.demo.repository.ShopV2Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopV2Service {
    @Autowired
    private ShopV2Repository shopV2Repository;

    public List<ShopV2> findAll() {
        return shopV2Repository.findAll();
    }

    public ShopV2 findOne(Long id) {
        return shopV2Repository.findById(id).orElse(null);
    }

    public List<ShopV2> findByName(String name) {
        return shopV2Repository.findByName(name);
    }

    public ShopV2 save(ShopV2 shop) {
        return shopV2Repository.save(shop);
    }

    public void delete(Long id) {
        shopV2Repository.deleteById(id);
    }
}