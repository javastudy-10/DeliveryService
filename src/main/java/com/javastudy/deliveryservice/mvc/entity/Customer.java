/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javastudy.deliveryservice.mvc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Tanya
 */
@Entity
@Table(name = "customers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"login", "phone", "email"})
)
public class Customer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    @Size(min = 6, max = 16)
    @NotNull
    private String login;

    @Column(name = "password")
    @Size(min = 6, max = 16)
    @NotNull
    private String password;

    @Column(name = "name")
    @Size(min = 3, max = 16)
    @NotNull
    private String name;

    @Column(name = "phone")
    @Size(min = 4, max = 20)
    @NotNull
    private String phone;

    @Column(name = "email")
    @Email
    @Size(min = 5, max = 64)
    @NotNull
    private String email;

    /* 
     @OneToOne
     @JoinColumn(name = "id_adress", referencedColumnName = "id")
     private Adress adress;
    
     */
}
