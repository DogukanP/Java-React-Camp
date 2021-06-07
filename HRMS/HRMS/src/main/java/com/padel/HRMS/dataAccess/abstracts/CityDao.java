package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City,Integer> {
}
