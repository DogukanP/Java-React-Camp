package com.padel.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    @NotNull(message = "companyName boş olamaz!")
    @NotBlank(message = "companyName boş olamaz!")
    private String companyName;

    @Column(name = "job_title")
    @NotNull(message = "jobTitle boş olamaz!")
    @NotBlank(message = "jobTitle boş olamaz!")
    private String jobTitle;

    @Column(name = "started_date")
    @NotNull(message = "startedDate boş olamaz!")
    @NotBlank(message = "startedDate boş olamaz!")
    @PastOrPresent
    private LocalDate startedDate;

    @Column(name = "end_date")
    @PastOrPresent
    private LocalDate endDate;

    @Column(name = "added_date")
    @NotNull(message = "addedDate boş olamaz!")
    @NotBlank(message = "addedDate boş olamaz!")
    @PastOrPresent
    private LocalDate addedDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
