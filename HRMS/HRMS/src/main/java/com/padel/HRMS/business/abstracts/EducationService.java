package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    Result add(Education education);
    DataResult<List<Education>> getAll();
    DataResult<Education> get(int id);
    DataResult<List<Education>> getAllOrderByEndDateDesc();
    DataResult<List<Education>> getByEndDateIsNull();
    DataResult<List<Education>> getByEndDateIsNotNullOrderByEndDateDesc();
}
