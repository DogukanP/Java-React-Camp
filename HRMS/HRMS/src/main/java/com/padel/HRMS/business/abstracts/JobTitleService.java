package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    DataResult<JobTitle> add(JobTitle title);


    DataResult<List<JobTitle>> getAll();
    DataResult<List<JobTitle>> findById(int id);

    DataResult<List<JobTitle>> findJobTitles(String title);
}
