package com.example.sneakershop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "users")
@Table
@Data
public class Users {
    @Id
    @SequenceGenerator(name = "users_generator", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_generator")
    private Long id;
    private String firstName;
    private String email;
    private String password;
    private String lastName;
    private String login;
}
