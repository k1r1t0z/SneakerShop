package com.example.sneakershop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "reviews")
@Table
public class Reviews {
    @Id
    private Long id;
    private Long sneakersId;
    private Integer rating;
    private String textReview;
    private Integer date;
}
