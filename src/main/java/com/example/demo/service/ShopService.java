package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Shop;
import com.example.demo.repository.ShopRepository;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public Shop findOne(Long id) {
        // メソッド名がfindOneからfindByIdに変わった
        // Optionalを返すようになったので取得できなかった場合の処理`.orElse(null)`を追加
        return shopRepository.findById(id).orElse(null);
    }

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    public void delete(Long id) {
        // メソッド名がdeleteからdeleteByIdに変わった       
        shopRepository.deleteById(id);
    }
}