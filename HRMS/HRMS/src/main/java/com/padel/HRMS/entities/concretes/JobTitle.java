package com.padel.HRMS.entities.concretes;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_titles")
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    @NotBlank(message = "title boş olamaz!")
    @NotNull(message = "title boş olamaz!")
    private String title;

    @OneToMany(mappedBy = "jobTitle")
    private List<JobAdvertisement> jobAdvertisements;


}
