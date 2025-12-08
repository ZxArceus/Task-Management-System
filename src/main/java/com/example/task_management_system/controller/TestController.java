package com.example.task_management_system.controller;

import com.example.task_management_system.model.User;
import com.example.task_management_system.repository.UserRepository;
import com.example.task_management_system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
   @Autowired
    private TestService testService;
    @Autowired
    private UserRepository userRepo;
   @GetMapping("/healthcheck")
    public String healthCheck(){
       return  "ok";
   }
   @PostMapping
    public  User createEntry( @RequestBody User user){
       return  userRepo.save(user);
   }
    @GetMapping
    public  ResponseEntity<?> getEntry(){
        List<User> all= testService.getAll();
        return  new ResponseEntity<>(all,HttpStatus.FOUND);
    }
}
