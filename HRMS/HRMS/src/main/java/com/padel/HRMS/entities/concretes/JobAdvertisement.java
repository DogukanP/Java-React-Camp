package com.padel.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "job_description")
    @NotBlank(message = "jobDescription boş olamaz!")
    @NotNull(message = "jobDescription boş olamaz!")
    private String jobDescription;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;

    @Column(name = "number_of_open_position")
    @NotBlank(message = "numberOfOpenPosition boş olamaz!")
    @NotNull(message = "numberOfOpenPosition boş olamaz!")
    private int numberOfOpenPosition;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    private Employer employer;

    @ManyToOne
    @NotBlank(message = "jobTitle boş olamaz!")
    @NotNull(message = "jobTitle boş olamaz!")
    private JobTitle jobTitle;

    @ManyToOne
    @NotBlank(message = "city boş olamaz!")
    @NotNull(message = "city boş olamaz!")
    private City city;
}
