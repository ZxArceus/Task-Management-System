package com.example.task_management_system.service;

import com.example.task_management_system.model.User;
import com.example.task_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TestService {
    @Autowired
    private UserRepository userRepo;
    public void saveEntry(User user) {


        userRepo.save(user);
    }
    public List<User> getAll(){
        return userRepo.findAll();

    }
}
