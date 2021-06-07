package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.ExperienceService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.core.utilities.results.SuccessResult;
import com.padel.HRMS.dataAccess.abstracts.ExperienceDao;
import com.padel.HRMS.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienceManager implements ExperienceService {
    final private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        super();
        this.experienceDao = experienceDao;
    }


    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.findAll(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Experience>> getAllOrderByEndDateDesc() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.getAllByOrderByEndDateDesc(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Experience>> getByEndDateIsNull() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.getByEndDateIsNull(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Experience>> getByEndDateIsNotNullOrderByEndDateDesc() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.getByEndDateIsNotNullOrderByEndDateDesc(),"Data Listelendi");
    }
}
