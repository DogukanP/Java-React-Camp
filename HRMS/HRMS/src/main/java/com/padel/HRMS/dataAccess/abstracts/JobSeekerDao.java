package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    List<JobSeeker> getByIdNumber(String idNumber);
}
