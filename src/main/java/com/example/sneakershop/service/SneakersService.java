package com.example.sneakershop.service;

import com.example.sneakershop.entity.Sneakers;
import com.example.sneakershop.repository.SneakersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Sneakers findByBrand(String brand) {
        return sneakersRepository.findByBrand(brand);
    }

    public Sneakers findBySize(Integer size) {
        return sneakersRepository.findBySize(size);
    }

    public Sneakers addDescription (Long id , String description) {
        Sneakers sneakers = sneakersRepository.findById(id).orElse(null);

        if(sneakers != null) {
            sneakers.setDescription(description);
            return sneakersRepository.save(sneakers);
        }
        return null;
    }

    public Sneakers uploadImage(Long sneakersId, MultipartFile file) throws IOException {
        Sneakers sneakers = sneakersRepository.findById(sneakersId).orElse(null);

        if (sneakers != null && !file.isEmpty()) {
            sneakers.setImage(file.getBytes());
            return sneakersRepository.save(sneakers);
        }

        return null;
    }

    public Sneakers updateAvailability(Long sneakersId, int newAvailability) {
        Sneakers sneakers = sneakersRepository.findById(sneakersId).orElse(null);

        if (sneakers != null) {
            sneakers.setAvailability(newAvailability);
            return sneakersRepository.save(sneakers);
        }

        return null;
    }

    @Transactional
    public List<Sneakers> findByPriceRange(Integer minPrice, Integer maxPrice) {
        return sneakersRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public void deleteSneakers(Long id) {
        sneakersRepository.deleteById(id);
    }
}
