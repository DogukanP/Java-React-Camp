package com.padel.HRMS.business.abstracts;


import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.entities.concretes.Employer;
import com.padel.HRMS.entities.concretes.SystemWorker;

import java.util.List;

public interface SystemWorkerService {
    DataResult<SystemWorker> add(SystemWorker systemWorker);
    DataResult<List<SystemWorker>> getAll();
}
