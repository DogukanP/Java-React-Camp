package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailVerificationDao extends JpaRepository<EmailVerification,Integer> {
    List<EmailVerification> findByUserId(Integer userId);
}
