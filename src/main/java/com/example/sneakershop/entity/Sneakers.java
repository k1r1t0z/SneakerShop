package com.example.sneakershop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "sneakers")
@Table
@Data
public class Sneakers {
    @Id
    @SequenceGenerator(name = "sneakers_generator", sequenceName = "sneakers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sneakers_generator")
    private Long id;
    private String name;
    private String brand;
    private Integer size;
    private String description;
    private Integer price;
    @Lob
    private byte[] image;
    private Integer availability;
}
