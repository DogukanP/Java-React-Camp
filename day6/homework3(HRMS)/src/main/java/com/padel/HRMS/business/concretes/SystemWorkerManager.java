package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.SystemWorkerService;
import com.padel.HRMS.dataAccess.abstracts.SystemWorkerDao;
import com.padel.HRMS.entities.concretes.SystemWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemWorkerManager implements SystemWorkerService {
    private SystemWorkerDao systemWorkerDao;

    @Autowired
    public SystemWorkerManager(SystemWorkerDao systemWorkerDao) {
        this.systemWorkerDao = systemWorkerDao;
    }

    @Override
    public List<SystemWorker> getAll() {
        return this.systemWorkerDao.findAll();
    }
}
