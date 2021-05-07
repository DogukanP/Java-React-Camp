package com.padel.dataAccess.concretes;

import com.padel.dataAccess.abstracts.UserDao;
import com.padel.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class abcUserDao implements UserDao {
    List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public boolean emailControl(User user) {
        for (User user1 : users){
            if (user1.getEmail() == user.getEmail()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean loginControl(String email, String password) {
        for (User user : users){
            if(user.getEmail() == email && user.getPassword() == password){
                return true;
            }
        }
        return false;
    }
}
