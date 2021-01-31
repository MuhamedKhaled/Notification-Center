package com.notificationcmd.service;

import com.notificationcmd.entities.Notification;
import com.notificationcmd.entities.User;
import com.notificationcmd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 *  IndividualType:
 *      set the notification
 *      select all users from db where user ids in notification consumers
 *      publish to them the message title, body
 */
public class IndividualType implements MessageTypeInterface{

    @Autowired
    UserRepository userRepository;


    @Override
    public void send(Notification notification) {
        System.out.println("From Individual Type.....");

//        ArrayList<User>users = new ArrayList<>();
//        notification.getConsumers().forEach(id -> {
//            users.add(userRepository.getOne(Integer.valueOf(id)));
//        });
        ProviderInit providerInit = new ProviderInit();

        providerInit.sendToProviders(notification);

    }



}
