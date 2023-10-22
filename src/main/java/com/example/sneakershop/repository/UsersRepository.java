package com.example.sneakershop.repository;

import com.example.sneakershop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findUsersByLogin(String login);
}
