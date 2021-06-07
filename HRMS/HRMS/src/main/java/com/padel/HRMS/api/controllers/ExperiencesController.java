package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.ExperienceService;
import com.padel.HRMS.core.utilities.results.ErrorDataResult;
import com.padel.HRMS.entities.concretes.Experience;
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
@RequestMapping("/api/experiences")
public class ExperiencesController {

    final private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        super();
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Experience experience) {
        return ResponseEntity.ok(this.experienceService.add(experience));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.experienceService.getAll());
    }

    @GetMapping("/getAllOrderByEndDateDesc")
    public ResponseEntity<?> getAllOrderByEndDateDesc() {
        return ResponseEntity.ok(this.experienceService.getAllOrderByEndDateDesc());
    }

    @GetMapping("/getByEndDateIsNull")
    public ResponseEntity<?> getByEndDateIsNull() {
        return ResponseEntity.ok(this.experienceService.getByEndDateIsNull());
    }

    @GetMapping("/getByEndDateIsNotNullOrderByEndDateDesc")
    public ResponseEntity<?> getByEndDateIsNotNullOrderByEndDateDesc() {
        return ResponseEntity.ok(this.experienceService.getByEndDateIsNotNullOrderByEndDateDesc());
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
