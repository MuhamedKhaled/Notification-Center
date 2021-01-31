package com.notificationcmd.service;

import com.notificationcmd.entities.Notification;
import com.notificationcmd.entities.User;

import java.util.ArrayList;

public interface MessageProvider {

    // for single users
    void send(Notification notification);

}
