package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> getByIsActiveTrue();
    List<JobAdvertisement> getByIsActiveTrueOrderByCreatedDate();
    List<JobAdvertisement> getByIsActiveTrueOrderByDeadline();
    List<JobAdvertisement> getByIsActiveTrueAndEmployerId(int userId);
}
