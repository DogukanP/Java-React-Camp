package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
}
