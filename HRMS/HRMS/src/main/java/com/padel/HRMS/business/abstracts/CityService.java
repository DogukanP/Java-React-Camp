package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
}
