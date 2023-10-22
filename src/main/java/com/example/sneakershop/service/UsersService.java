package com.example.sneakershop.service;

import com.example.sneakershop.entity.Users;
import com.example.sneakershop.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUsers(Users users) {
        return usersRepository.save(users);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users updateUsers(Long id, Users updateUsers) {
        Users existingUsers = usersRepository.findById(id).orElse(null);
        if(existingUsers != null) {
            existingUsers.setFirstName(updateUsers.getFirstName());
            existingUsers.setLastName(updateUsers.getLastName());
            existingUsers.setEmail(updateUsers.getEmail());
            return usersRepository.save(existingUsers);
        }
        return null;
    }

    public Users getUserByLogin(String login) {
        return usersRepository.findUsersByLogin(login);
    }

    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }
}
