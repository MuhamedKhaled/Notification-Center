package com.notificationcmd.utils;

import com.notificationcmd.entities.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    // method divide list of users to chunks
    public static List<List<String>> toChunks(ArrayList<String> users,int chunkSize){
        List<List<String>> Chunks = new ArrayList<>();

        for (int i=0; i<users.size(); i += chunkSize) {
            Chunks.add(users.subList(i, Math.min(i + chunkSize, users.size())));
        }

        return Chunks;
    }
}
