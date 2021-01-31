package com.notificationcmd.service;

import com.notificationcmd.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicType implements MessageTypeInterface{


    @Override
    public void send(Notification notification) {
        System.out.println("From Topic provider.....");
        ProviderInit providerInit = new ProviderInit();
        providerInit.sendToProviders(notification);

    }
}
