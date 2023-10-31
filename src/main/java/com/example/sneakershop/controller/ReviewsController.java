package com.example.sneakershop.controller;

import com.example.sneakershop.entity.Reviews;
import com.example.sneakershop.service.ReviewsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping("/create")
    public Reviews createReviews(@RequestBody Reviews reviews) {
        return reviewsService.createReviews(reviews);
    }

    @GetMapping("/all")
    public List<Reviews> getAllReviews() {
        return reviewsService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Reviews getReviewsById(@PathVariable Long id) {
        return reviewsService.getReviewsById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReviews(@PathVariable Long id) {
        reviewsService.deleteReviews(id);
    }
}
