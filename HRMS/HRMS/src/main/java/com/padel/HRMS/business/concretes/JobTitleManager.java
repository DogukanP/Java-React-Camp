package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.JobTitleService;
import com.padel.HRMS.dataAccess.abstracts.JobTitleDao;
import com.padel.HRMS.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return this.jobTitleDao.findAll();
    }
}
