package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.JobAdvertisementService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.core.utilities.results.SuccessResult;
import com.padel.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import com.padel.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    final private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }


    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(),"Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActiveOrderByCreatedDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByCreatedDate(),"Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActiveOrderByDeadline() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByDeadline(),"Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int userId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployerId(userId),"Data listelendi");
    }

    @Override
    public Result changedActivated(int jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementId).get();
        if(jobAdvertisement.isActive()){
            jobAdvertisement.setActive(false);
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İlan pasif hale getirildi");
        }
        jobAdvertisement.setActive(true);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İlan aktif hale getirildi");
    }
}
