package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.CityService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.dataAccess.abstracts.CityDao;
import com.padel.HRMS.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    final private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Data listelendi");
    }
}
