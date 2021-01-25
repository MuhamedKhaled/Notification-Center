package com.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "user")
@Data
public class User {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "name")
    private String name;

    @Column(name= "email")
    private String email;

}
