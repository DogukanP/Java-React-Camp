package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    List<JobTitle> getAll();
}
