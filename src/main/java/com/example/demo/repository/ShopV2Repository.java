package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.ShopV2;

@Repository
public interface ShopV2Repository extends JpaRepository<ShopV2, Long> {
    List<ShopV2> findByName(String name);
}