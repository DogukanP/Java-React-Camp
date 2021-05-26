package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
    @Query("select u from JobTitle u where lower(u.title) like lower(concat('%', :title,'%'))")
    List<JobTitle> findJobTitles(@Param("title") String title);

    List<JobTitle> findById(@Param("") int id);

    Optional<JobTitle> findOneByTitle(@Param("") String title);

    List<JobTitle> findAllByTitle(String title);
}
