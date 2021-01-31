package com.notificationcmd.listener;

import com.notificationcmd.dto.MessageDto;
import com.notificationcmd.rabbitMq.MessagingConfig;
import com.notificationcmd.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    NotificationService notificationService;

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(MessageDto message) throws Exception {
        System.out.println("Message received from queue : " + message.getNotification_id());
        notificationService.sendNotification(message.getNotification_id());
    }
}
