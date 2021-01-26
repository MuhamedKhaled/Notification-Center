package com.demo.controllers;


import com.demo.entities.Notification;
import com.demo.entities.User;
import com.demo.repository.NotificationRepository;
import com.demo.repository.UserRepository;
import com.demo.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUsers() {
        userRepository.deleteAll();
        System.out.println("Deleting users.... ");
        return ResponseEntity.ok("Users has been deleted successfully");
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> saveUsers(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user = userRepository.save(user);
        System.out.println("save user: "+user);
        return ResponseEntity.ok("User has been added successfully");
    }

}
