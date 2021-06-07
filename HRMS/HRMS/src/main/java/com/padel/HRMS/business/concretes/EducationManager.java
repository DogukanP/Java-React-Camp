package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.EducationService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.core.utilities.results.SuccessResult;
import com.padel.HRMS.dataAccess.abstracts.EducationDao;
import com.padel.HRMS.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    final private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        super();
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>( this.educationDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<Education> get(int id) {
        return new SuccessDataResult<Education>(this.educationDao.findById(id).get(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Education>> getAllOrderByEndDateDesc() {
        return new SuccessDataResult<List<Education>>(this.educationDao.getAllByOrderByEndDateDesc(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Education>> getByEndDateIsNull() {
        return new SuccessDataResult<List<Education>>(this.educationDao.getByEndDateIsNull(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Education>> getByEndDateIsNotNullOrderByEndDateDesc() {
        return new SuccessDataResult<List<Education>>(this.educationDao.getByEndDateIsNotNullOrderByEndDateDesc(),"Data Listelendi");
    }
}
