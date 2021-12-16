package ru.gb.shop.inventory.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name = "USERS")
@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "login",unique = true,nullable = false)
    private String login;
    @Column (name = "password",nullable = false)
    private char[] password;
    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false,foreignKey = @ForeignKey(name = "FK_role_user_id"))
    private Role role;


}
