package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.JobTitleService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.entities.concretes.JobTitle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitle/")
public class JobTitlesController {
    final private JobTitleService jobTitleService;

    public JobTitlesController(JobTitleService jobTitleService) {
        super();
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobTitle>> getAll(){
        return jobTitleService.getAll();
    }

    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public DataResult<List<JobTitle>> findById(@PathVariable("id") Integer id){
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "/findbytitle/{title}", method = RequestMethod.GET)
    public DataResult<List<JobTitle>> findByTitle(@PathVariable("title") String title){
        return jobTitleService.findJobTitles(title);
    }

    @PostMapping("/add")
    public DataResult<JobTitle> add(JobTitle title){
        return this.jobTitleService.add(title);
    }

}
