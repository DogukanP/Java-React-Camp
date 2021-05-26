package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    List<JobSeeker> findAllByEmail(String email);
    List<JobSeeker> findAllByIdentificationNumber(String identificationNumber);
}
