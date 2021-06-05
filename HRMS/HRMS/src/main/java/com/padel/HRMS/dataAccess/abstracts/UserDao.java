package com.padel.HRMS.dataAccess.abstracts;

import com.padel.HRMS.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    List<User> getByEmail(String email);
}
