package ru.gb.shop.inventory.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "ROLES")
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "role",unique = true,nullable = false)
    private String role;


}
