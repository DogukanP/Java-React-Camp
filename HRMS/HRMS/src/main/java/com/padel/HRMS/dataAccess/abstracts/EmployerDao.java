package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
}
