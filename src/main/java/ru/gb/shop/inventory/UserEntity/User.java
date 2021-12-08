package ru.gb.shop.inventory.UserEntity;


import lombok.Data;

import javax.persistence.*;

@Table(name = "USERS")
@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "login",unique = true,nullable = false)
    private String login;
    @Column (name = "password",nullable = false)
    private char[] password;
    @OneToOne
    @JoinColumn(name = "role_id",foreignKey = @ForeignKey(name = "FK_role_user_id"))
    private Role role;

}
