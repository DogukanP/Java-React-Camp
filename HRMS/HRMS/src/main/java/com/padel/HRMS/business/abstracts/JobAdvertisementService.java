package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getByActive();
    DataResult<List<JobAdvertisement>> getByActiveOrderByCreatedDate();
    DataResult<List<JobAdvertisement>> getByActiveOrderByDeadline();
    DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int userId);
    Result changedActivated(int jobAdvertisementId);
}
