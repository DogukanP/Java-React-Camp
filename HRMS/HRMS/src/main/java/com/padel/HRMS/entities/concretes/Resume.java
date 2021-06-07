package com.padel.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "image_Url")
    private String imageUrl;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Education> educations;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

}
