package com.notificationcmd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationcmd.entities.Notification;
import com.notificationcmd.entities.User;
import com.notificationcmd.utils.Utils;

import java.util.*;

public class SmsProvider implements MessageProvider{

    public static final int MPT = 100; // 100 message per TIM
    public static final int TIM = 60 * 1000; // 1 min in milliseconds
    /**
     * start sending the message
     * @param notification,ArrayList<String>users
     */
    Timer timer;
    @Override
    public void send(Notification notification) {
        // chunk list of users that should we notify them
        List<List<String>> chunks = Utils.toChunks(notification.getConsumers(),MPT);
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("in Chunk part......");
                if (chunks.size()>0){
                    processMessage(notification,chunks.get(0));
                    chunks.remove(0);
                }else{
                    // chunks is empty so we just clear the timer and we are done
                    timer.cancel();
                }

            }
        },0,TIM);
    }

    /**
     * use the provider SDK to send the message
     * @param notification
     * @param users
     */
    private void processMessage(Notification notification,List<String>users){
        // send notificaiotn to chunk of users
        System.out.println("================SMS=========================");
        System.out.println("notification title: "+notification.getTitle());
        System.out.println("notification body: "+notification.getBody());
        System.out.println("Kind: " + notification.getKind());
        System.out.println("sendTo: " + Arrays.toString(users.toArray()));
        System.out.println("=========================================");

    }

}
