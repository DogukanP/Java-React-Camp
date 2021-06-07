package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeDao extends JpaRepository<Resume,Integer> {
    List<Resume> getByJobSeeker_Id(int id);
}
