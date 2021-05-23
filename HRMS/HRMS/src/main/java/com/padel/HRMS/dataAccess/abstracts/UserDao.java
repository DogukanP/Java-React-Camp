package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
