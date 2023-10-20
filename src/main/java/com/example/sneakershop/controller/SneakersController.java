package com.example.sneakershop.controller;

import com.example.sneakershop.entity.Sneakers;
import com.example.sneakershop.service.SneakersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sneakers")
public class SneakersController {
    SneakersService sneakersService;

    public SneakersController(SneakersService sneakerService) {
        this.sneakersService = sneakerService;
    }

    @PostMapping("/create")
    public Sneakers createSneakers(@RequestBody Sneakers sneakers) {
        return sneakersService.createSneakers(sneakers);
    }

    @GetMapping("/all")
    public List<Sneakers> getAllSneakers() {
        return sneakersService.getAllSneakers();
    }

    @GetMapping("/{id}")
    public Sneakers getSneakersById(@PathVariable Long id) {
        return sneakersService.getSneakersById(id);
    }

    @PutMapping("/update/{id}")
    public Sneakers updateSneakers(@PathVariable Long id, @RequestBody Sneakers updatedSneakers) {
        return sneakersService.updateSneakers(id, updatedSneakers);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSneakers(@PathVariable Long id) {
        sneakersService.deleteSneakers(id);
    }
}
