package com.padel.HRMS.entities.concretes;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="password")
    private String password;

}
