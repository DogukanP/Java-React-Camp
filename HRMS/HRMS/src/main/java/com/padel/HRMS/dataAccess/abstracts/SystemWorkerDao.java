package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.SystemWorker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemWorkerDao extends JpaRepository<SystemWorker,Integer> {
    List<SystemWorker> findAllByEmail(String email);
}
