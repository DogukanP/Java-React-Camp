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
@Table(name="skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "skill_name")
    @NotBlank(message = "skillName boş olamaz!")
    @NotNull(message = "skillName boş olamaz!")
    private String skillName;

    @Column(name = "added_date")
    @NotNull(message = "addedDate boş olamaz!")
    @NotBlank(message = "addedDate boş olamaz!")
    @PastOrPresent
    private LocalDate addedDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
