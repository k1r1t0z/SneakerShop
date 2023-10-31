package com.example.sneakershop.service;

import com.example.sneakershop.entity.Reviews;
import com.example.sneakershop.repository.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {
    ReviewsRepository reviewsRepository;

    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public Reviews createReviews(Reviews reviews) {
        return reviewsRepository.save(reviews);
    }

    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    public Reviews getReviewsById(Long id) {
        return reviewsRepository.findById(id).orElse(null);
    }

    public void deleteReviews(Long id) {
        reviewsRepository.deleteById(id);
    }
}
