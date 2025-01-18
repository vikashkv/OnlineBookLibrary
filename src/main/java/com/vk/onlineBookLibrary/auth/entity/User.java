package com.vk.onlineBookLibrary.auth.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles userRole;
}
