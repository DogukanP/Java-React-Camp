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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_name")
    @NotNull(message = "languageName boş olamaz!")
    @NotBlank(message = "languageName boş olamaz!")
    private String languageName;

    @Column(name = "degree")
    @NotNull(message = "degree boş olamaz!")
    @NotBlank(message = "degree boş olamaz!")
    @DecimalMin(value = "1")
    @DecimalMax(value = "5")
    private Byte degree;

    @Column(name = "added_date")
    @NotNull(message = "addedDate boş olamaz!")
    @NotBlank(message = "addedDate boş olamaz!")
    @PastOrPresent
    private LocalDate addedDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
