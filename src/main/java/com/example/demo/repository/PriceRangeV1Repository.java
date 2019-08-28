package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.PriceRangeV1;

@Repository
public interface PriceRangeV1Repository extends JpaRepository<PriceRangeV1, Long> {
    List<PriceRangeV1> findByName(String name);
}