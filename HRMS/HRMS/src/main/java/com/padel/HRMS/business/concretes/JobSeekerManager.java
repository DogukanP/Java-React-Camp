package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.JobSeekerService;
import com.padel.HRMS.dataAccess.abstracts.JobSeekerDao;
import com.padel.HRMS.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public List<JobSeeker> getAll() {
        return this.jobSeekerDao.findAll();
    }
}
