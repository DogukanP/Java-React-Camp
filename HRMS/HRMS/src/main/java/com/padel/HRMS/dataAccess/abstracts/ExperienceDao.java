package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceDao extends JpaRepository<Experience,Integer> {
    List<Experience> getAllByOrderByEndDateDesc();
    List<Experience> getByEndDateIsNull();
    List<Experience> getByEndDateIsNotNullOrderByEndDateDesc();
}
