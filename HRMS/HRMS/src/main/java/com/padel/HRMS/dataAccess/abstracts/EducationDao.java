package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDao extends JpaRepository<Education,Integer> {
    List<Education> getAllByOrderByEndDateDesc();
    List<Education> getByEndDateIsNull();
    List<Education> getByEndDateIsNotNullOrderByEndDateDesc();
}
