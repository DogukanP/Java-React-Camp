package com.padel.HRMS.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "employers")
public class Employer extends User {
    @Column(name = "company_name")
    @NotBlank(message = "companyName boş olamaz!")
    @NotNull(message = "companyName boş olamaz!")
    private String companyName;

    @Column(name = "web_address")
    @NotBlank(message = "webAddress boş olamaz!")
    @NotNull(message = "webAddress boş olamaz!")
    private String webAddress;

    @Column(name = "phone_number")
    @NotBlank(message = "phoneNumber boş olamaz!")
    @NotNull(message = "phoneNumber boş olamaz!")
    private String phoneNumber;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
