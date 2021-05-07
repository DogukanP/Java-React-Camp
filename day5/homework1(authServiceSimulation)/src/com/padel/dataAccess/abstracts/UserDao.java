package com.padel.dataAccess.abstracts;

import com.padel.entities.concretes.User;

public interface UserDao {
    void add(User user);
    boolean emailControl(User user);
    boolean loginControl(String email, String password);
}
