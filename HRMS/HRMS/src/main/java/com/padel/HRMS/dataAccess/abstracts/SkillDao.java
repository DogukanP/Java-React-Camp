package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDao extends JpaRepository<Skill,Integer> {
}
