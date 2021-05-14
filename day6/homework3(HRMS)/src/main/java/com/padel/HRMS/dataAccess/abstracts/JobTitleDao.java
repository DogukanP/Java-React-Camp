package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
}
