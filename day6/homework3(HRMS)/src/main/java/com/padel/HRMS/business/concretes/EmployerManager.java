package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.EmployerService;
import com.padel.HRMS.dataAccess.abstracts.EmployerDao;
import com.padel.HRMS.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public List<Employer> getAll() {
        return this.employerDao.findAll();
    }
}
