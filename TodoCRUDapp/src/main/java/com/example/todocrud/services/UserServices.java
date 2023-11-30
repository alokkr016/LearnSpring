package com.example.todocrud.services;

import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public Users getUserById (Long userId){
        //write code
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    public Users addUser(Users user){
        //write code
        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        //write code
        userRepository.deleteById(userId);
    }

    public void updateUser(Users user){
       //write code
        userRepository.save(user);
    }

}
