package com.padel.HRMS.entities.concretes;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email_address")
    @Email(message = "Hatali email!")
    @NotBlank(message = "Bu alan boş olamaz!")
    @NotNull(message = "Bu alan boş olamaz!")
    private String email;

    @Column(name="password")
    @NotBlank(message = "Bu alan boş olamaz!")
    @NotNull(message = "Bu alan boş olamaz!")
    private String password;

}
