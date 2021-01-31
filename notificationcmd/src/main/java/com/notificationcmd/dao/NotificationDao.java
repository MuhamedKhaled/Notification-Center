package com.notificationcmd.dao;

import com.notificationcmd.entities.Notification;

public interface NotificationDao {

    Notification getNotifications(Integer notificationId);

}
