package com.notificationcmd.service;

import com.notificationcmd.entities.Notification;
import com.notificationcmd.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


public class ProviderInit {


    public void sendToProviders(Notification notification){
        notification.getProviders().forEach(provider -> {
            MessageProvider messageProvider = null;
            if (provider.equalsIgnoreCase("sms"))
                messageProvider = new SmsProvider();
            if (provider.equalsIgnoreCase("fcm"))
                messageProvider = new FcmProvider();
            if (provider.equalsIgnoreCase("email"))
                messageProvider = new EmailProvider();

            if (messageProvider!=null)
                messageProvider.send(notification);

        });
    }

}
