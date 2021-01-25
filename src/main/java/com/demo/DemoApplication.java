package com.demo;

import com.demo.entities.Notification;
import com.demo.entities.User;
import com.demo.repository.NotificationRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    UserRepository userRepository;
    @Autowired
    NotificationRepository notificationRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
