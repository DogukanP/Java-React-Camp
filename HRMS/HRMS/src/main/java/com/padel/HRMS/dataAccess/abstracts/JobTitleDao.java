package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
    @Query("select u from JobTitle u where lower(u.title) like lower(concat('%', :title,'%'))")
    List<JobTitle> getJobTitles(@Param("title") String title);

    List<JobTitle> getById(@Param("") int id);

    Optional<JobTitle> getOneByTitle(@Param("") String title);

    List<JobTitle> getByTitle(String title);
}
