package com.example.sneakershop.repository;

import com.example.sneakershop.domain.Sneakers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakersRepository extends JpaRepository<Sneakers, Long> {

}
