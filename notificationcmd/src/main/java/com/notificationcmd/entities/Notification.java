package com.notificationcmd.entities;


import com.notificationcmd.utils.ArrayConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name= "notification")
@Data
public class Notification {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "title")
    private String title;

    @Column(name= "body")
    private String body;

    @Column(name= "kind")
    private String kind;

    @Column(name = "consumers")
    @Convert(converter = ArrayConverter.class)
    private ArrayList<String>  consumers;

    @Column(name= "providers")
   @Convert(converter = ArrayConverter.class)
    private ArrayList<String> providers;

}
