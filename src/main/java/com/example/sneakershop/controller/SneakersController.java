package com.example.sneakershop.controller;

import com.example.sneakershop.entity.Sneakers;
import com.example.sneakershop.service.SneakersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/search/brand/{brand}")
    public Sneakers getByBrand(@PathVariable String brand){
        return sneakersService.findByBrand(brand);
    }

    @GetMapping("/search/size/{size}")
    public Sneakers getBySize(@PathVariable Integer size) {
        return sneakersService.findBySize(size);
    }

    @PostMapping("/add_description")
    public Sneakers addDescription(@RequestParam Long id, @RequestParam String description) {
        return sneakersService.addDescription(id, description);
    }

    @PostMapping("/{id}/uploadImage")
    public ResponseEntity<String> handleFileUpload(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        try {
            Sneakers updatedSneakers = sneakersService.uploadImage(id, file);
            if (updatedSneakers != null) {
                return ResponseEntity.ok("Image uploaded successfully");
            } else {
                return ResponseEntity.badRequest().body("Failed to upload image");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PatchMapping("/{id}/updateAvailability")
    public ResponseEntity<String> updateAvailability(
            @PathVariable Long id,
            @RequestParam Integer newAvailability) {
        Sneakers updatedSneakers = sneakersService.updateAvailability(id, newAvailability);

        if (updatedSneakers != null) {
            return ResponseEntity.ok("Availability in stock updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update availability in stock");
        }
    }

    @GetMapping("/findByPriceRange")
    public ResponseEntity<List<Sneakers>> findByPriceRange(
            @RequestParam Integer minPrice,
            @RequestParam Integer maxPrice) {
        List<Sneakers> sneakersList = sneakersService.findByPriceRange(minPrice, maxPrice);

        if (sneakersList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(sneakersList);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSneakers(@PathVariable Long id) {
        sneakersService.deleteSneakers(id);
    }
}
