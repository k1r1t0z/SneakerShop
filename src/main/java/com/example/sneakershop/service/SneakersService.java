package com.example.sneakershop.service;

import com.example.sneakershop.entity.Sneakers;
import com.example.sneakershop.repository.SneakersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SneakersService {
    SneakersRepository sneakersRepository;

    public SneakersService(SneakersRepository sneakersRepository) {
        this.sneakersRepository = sneakersRepository;
    }

    public Sneakers createSneakers(Sneakers sneakers) {
        return sneakersRepository.save(sneakers);
    }

    public List<Sneakers> getAllSneakers() {
        return sneakersRepository.findAll();
    }

    public Sneakers getSneakersById(Long id) {
        return sneakersRepository.findById(id).orElse(null);
    }

    public Sneakers updateSneakers(Long id, Sneakers updatedSneakers) {
        Sneakers existingSneakers = sneakersRepository.findById(id).orElse(null);
        if (existingSneakers != null) {
            existingSneakers.setName(updatedSneakers.getName());
            existingSneakers.setBrand(updatedSneakers.getBrand());
            existingSneakers.setPrice(updatedSneakers.getPrice());
            return sneakersRepository.save(existingSneakers);
        }
        return null;
    }

    public void deleteSneakers(Long id) {
        sneakersRepository.deleteById(id);
    }
}
