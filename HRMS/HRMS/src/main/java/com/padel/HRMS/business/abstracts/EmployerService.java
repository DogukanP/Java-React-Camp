package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
}
