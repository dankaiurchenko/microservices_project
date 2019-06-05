package com.danarossa.gateway.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "public", catalog = "my_servlet_project")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Timestamp dateEntered;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateEntered = new Timestamp(new Date().getTime());
    }

}
