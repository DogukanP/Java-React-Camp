package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.entities.concretes.SystemWorker;

import java.util.List;

public interface SystemWorkerService {
    List<SystemWorker> getAll();
}
