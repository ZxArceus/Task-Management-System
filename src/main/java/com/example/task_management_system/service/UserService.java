package com.example.task_management_system.service;

import com.example.task_management_system.model.User;
import com.example.task_management_system.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    private  User saveUser(User user){
        return userRepository.save(user);

    }
    private Optional<User> getUserById(ObjectId userId){
        try{
            return  userRepository.findById(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Optional<User> getUserByName(String username){
        try{
            return  userRepository.findByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private boolean existsByName(String username){
        try{
            return  userRepository.existsByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private boolean existsByemail(String email){
        try{
            return  userRepository.existsByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
