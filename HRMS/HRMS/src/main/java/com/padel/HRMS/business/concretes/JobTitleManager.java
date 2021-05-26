package com.padel.HRMS.business.concretes;


import com.padel.HRMS.business.abstracts.JobTitleService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.ErrorDataResult;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.dataAccess.abstracts.JobTitleDao;
import com.padel.HRMS.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobTitleManager implements JobTitleService {
    @Autowired
    private JobTitleDao jobTitleDao;

    public JobTitleManager() {

    }

    @Override
    public DataResult<JobTitle> add(JobTitle title) {
        if(jobTitleDao.findAllByTitle(title.getTitle()).stream().count() !=0 ) {
            return new ErrorDataResult<JobTitle>(null,"Böyle Bir İş Pozisyonu Zaten Kayıtlı");

        }
        return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(title),"Başarıyla İş Pozisyonu Eklendi");
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(),"Başarılı Şekilde Listelendi");
    }

    @Override
    public DataResult<List<JobTitle>> findById(int id) {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findById(id),"Başarı Şekilde Listelendi");
    }

    @Override
    public DataResult<List<JobTitle>> findJobTitles(String title) {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findJobTitles(title),"Başarı Şekilde Listelendi");
    }
}
