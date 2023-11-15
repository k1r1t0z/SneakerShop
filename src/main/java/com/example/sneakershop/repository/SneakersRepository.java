package com.example.sneakershop.repository;

import com.example.sneakershop.entity.Sneakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SneakersRepository extends JpaRepository<Sneakers, Long> {
    Sneakers findByBrand(String brand);
    Sneakers findBySize(Integer size);
    List<Sneakers> findByPriceBetween(Integer minPrice, Integer maxPrice);
}
