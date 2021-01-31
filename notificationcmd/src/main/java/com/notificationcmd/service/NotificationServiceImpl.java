package com.notificationcmd.service;


import com.notificationcmd.dao.NotificationDao;
import com.notificationcmd.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationDao notificationDao;



    @Override
    public void sendNotification(Integer notificationId) throws Exception {
        Notification notification = notificationDao.getNotifications(notificationId);
        if (notification == null)
            throw new Exception("no notifications found");

        MessageTypeInterface messageTypeInterface = getMessageKind(notification.getKind());
        messageTypeInterface.send(notification);




    }


    // method for check what is kind of message
    // declare interface based on type and return it
    private MessageTypeInterface getMessageKind(String kind) throws Exception {
        // in case of individual type
        if (kind.equalsIgnoreCase("in")){
            return new IndividualType();
        }
        // in case of topic type
        else if (kind.equalsIgnoreCase("tp")){
            return new TopicType();
        }
        throw new Exception("Message type not found");
    }
}
