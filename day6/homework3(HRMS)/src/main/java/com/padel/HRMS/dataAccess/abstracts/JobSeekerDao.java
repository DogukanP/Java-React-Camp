package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
}
