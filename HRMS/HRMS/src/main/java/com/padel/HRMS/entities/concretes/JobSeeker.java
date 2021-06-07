package com.padel.HRMS.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers")
public class JobSeeker extends User {
    @Column(name = "first_name")
    @NotBlank(message = "firstName boş olamaz!")
    @NotNull(message = "firstName boş olamaz!")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "lastName boş olamaz!")
    @NotNull(message = "lastName boş olamaz!")
    private String lastName;

    @Column(name = "identification_number")
    @NotBlank(message = "idNumber boş olamaz!")
    @NotNull(message = "idNumber boş olamaz!")
    private String idNumber;

    @Column(name = "birth_date")
    @Past
    private Date birthDate;
}
