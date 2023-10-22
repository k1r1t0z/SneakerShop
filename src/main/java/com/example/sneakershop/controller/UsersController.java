package com.example.sneakershop.controller;

import com.example.sneakershop.entity.Users;
import com.example.sneakershop.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    public Users createUser(@RequestBody Users users) {
        return usersService.createUsers(users);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUsersById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public Users updateUsers(@PathVariable Long id, @RequestBody Users updatedUsers) {
        return usersService.updateUsers(id, updatedUsers);
    }

    @GetMapping("/search")
    public ResponseEntity<Users> getUserByLogin(@RequestParam("login") String login) {
        Users user = usersService.getUserByLogin(login);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
    }
}
