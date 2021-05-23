package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.SystemWorkerService;
import com.padel.HRMS.entities.concretes.SystemWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/systemWorker")
public class SystemWorkersController {
    private SystemWorkerService systemWorkerService;

    @Autowired
    public SystemWorkersController(SystemWorkerService systemWorkerService) {
        this.systemWorkerService = systemWorkerService;
    }

    @GetMapping("getAll")
    public List<SystemWorker> getAll(){
        return this.systemWorkerService.getAll();
    }
}
