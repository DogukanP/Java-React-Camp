package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    Result add(Experience experience);
    DataResult<List<Experience>> getAll();
    DataResult<List<Experience>> getAllOrderByEndDateDesc();
    DataResult<List<Experience>> getByEndDateIsNull();
    DataResult<List<Experience>> getByEndDateIsNotNullOrderByEndDateDesc();
}
