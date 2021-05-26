package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.SystemWorkerService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.SystemWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemWorker")
public class SystemWorkersController {
    private final SystemWorkerService systemWorkerService;

    @Autowired
    public SystemWorkersController(SystemWorkerService systemWorkerService) {
        this.systemWorkerService = systemWorkerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<SystemWorker>> getAll(){
        return this.systemWorkerService.getAll();
    }

    @GetMapping("/findByEmail")
    public DataResult<List<SystemWorker>> findByEmailIs(@RequestBody String email){
        return this.systemWorkerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SystemWorker systemWorker){
        return this.systemWorkerService.add(systemWorker);
    }
}
