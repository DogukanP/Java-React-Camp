package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.ResumeService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.core.utilities.results.SuccessResult;
import com.padel.HRMS.dataAccess.abstracts.ResumeDao;
import com.padel.HRMS.entities.concretes.City;
import com.padel.HRMS.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    final private ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        super();
        this.resumeDao = resumeDao;
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<List<Resume>> getByJobSeekerId(int id) {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.getByJobSeeker_Id(id),"Data listelendi");
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<String> uploadPhoto(int id, String imageUrl) {
        return null;
    }
}
