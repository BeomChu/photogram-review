package com.cos.photogramstart.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(length = 20,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    private String website;
    @Column(nullable = false)
    private String email;
    private String phone;
    private String bio;
    private String gender;

    private String profileImageUrl; // 주소

    private String role;

    private LocalDateTime createDate;


    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

    @Builder
    public User(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = "ROLE_USER";
    }
}
