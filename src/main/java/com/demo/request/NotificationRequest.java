package com.demo.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationRequest implements Serializable {

       private String kind;
       private String title;
       private String body;
       private ArrayList<String>providers;
       private ArrayList<String>consumers;

}
