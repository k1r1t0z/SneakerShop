package com.example.sneakershop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "orders")
@Table
public class Orders {
    @Id
    private Long id;
    private Long usersId;
    private Integer dateOrder;
    private Long sneakerId;
}
