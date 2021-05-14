package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    List<JobSeeker> getAll();
}
