package com.padel.HRMS.business.concretes;


import com.padel.HRMS.business.abstracts.JobSeekerService;
import com.padel.HRMS.dataAccess.abstracts.UserDao;
import com.padel.HRMS.core.utilities.results.*;
import com.padel.HRMS.dataAccess.abstracts.JobSeekerDao;
import com.padel.HRMS.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    final private JobSeekerDao jobSeekerDao;
    final private UserDao userDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.userDao = userDao;
    }


    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {

        if(this.userDao.getByEmail(jobSeeker.getEmail()).stream().count() == 0 && this.jobSeekerDao.getByIdNumber(jobSeeker.getIdNumber()).stream().count() == 0){
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Data eklendi");
        }else return new ErrorResult("Data eklenemedi");

    }
}
