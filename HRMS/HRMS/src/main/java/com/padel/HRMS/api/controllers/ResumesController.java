package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.ResumeService;
import com.padel.HRMS.core.utilities.results.ErrorDataResult;
import com.padel.HRMS.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
    final private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        super();
        this.resumeService = resumeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.resumeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Resume resume) {
        return ResponseEntity.ok(this.resumeService.add(resume));
    }

    @GetMapping("/getAllByJobSeekerId")
    public ResponseEntity<?> getAllByJobSeekerId(@RequestParam(name = "id") int id) {
        return ResponseEntity.ok(this.resumeService.getByJobSeekerId(id));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
