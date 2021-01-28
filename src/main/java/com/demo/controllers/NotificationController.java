package com.demo.controllers;

import com.demo.entities.Notification;
import com.demo.request.NotificationRequest;
import com.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("notification")
@RestController
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/notifications", method = RequestMethod.GET)
    public ResponseEntity<List<Notification>> getNotifications(){

        List<Notification>notifications = notificationService.getNotification();

        return ResponseEntity.ok(notifications);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<String> NotificationsSend(@RequestBody NotificationRequest notificationRequest){
        notificationService.sendNotification(notificationRequest);
        return ResponseEntity.ok("Notification has been added successfully");
    }



}
