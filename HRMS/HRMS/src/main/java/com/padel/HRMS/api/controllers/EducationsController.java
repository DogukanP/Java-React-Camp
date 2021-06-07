package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.EducationService;
import com.padel.HRMS.core.utilities.results.ErrorDataResult;
import com.padel.HRMS.entities.concretes.Education;
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
@RequestMapping("/api/educations")
public class EducationsController {

    final private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        super();
        this.educationService = educationService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.educationService.getAll());
    }

    @GetMapping("/getAllOrderByEndDateDesc")
    public ResponseEntity<?> getAllOrderByEndDateDesc() {
        return ResponseEntity.ok(this.educationService.getAllOrderByEndDateDesc());
    }

    @GetMapping("/getByEndDateIsNull")
    public ResponseEntity<?> getByEndDateIsNull() {
        return ResponseEntity.ok(this.educationService.getByEndDateIsNull());
    }

    @GetMapping("/getByEndDateIsNotNullOrderByEndDateDesc")
    public ResponseEntity<?> getByEndDateIsNotNullOrderByEndDateDesc() {
        return ResponseEntity.ok(this.educationService.getByEndDateIsNotNullOrderByEndDateDesc());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Education education) {
        return ResponseEntity.ok(this.educationService.add(education));
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
