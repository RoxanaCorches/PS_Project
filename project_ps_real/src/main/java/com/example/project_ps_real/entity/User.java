package com.example.project_ps_real.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name ="users")
@Setter
@Getter
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="score")
    private Float score;

    @Column(name="is_admin")
    private Boolean isAdmin;

    @Column(name="is_banned")
    private Boolean isBanned;

    @OneToMany
    @JoinColumn(name = "user_id")  // Cheie străină către User
    private List<Post> posts;

    public User(Long userId, String name, String password, String email, String phoneNumber, Float score, Boolean isAdmin, Boolean isBanned) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.score = score;
        this.isAdmin = isAdmin;
        this.isBanned = isBanned;
    }

    public User() {

    }
}
