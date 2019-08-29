package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.CategoryV1;
import com.example.demo.repository.CategoryV1Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryV1Service {
    @Autowired
    private CategoryV1Repository categoryV1Repository;

    public List<CategoryV1> findAll() {
        return categoryV1Repository.findAll();
    }

    public CategoryV1 findById(Long id) {
        return categoryV1Repository.findById(id).orElse(null);
    }

    public CategoryV1 findByName(String name) {
        return categoryV1Repository.findByName(name).get(0);
    }
}