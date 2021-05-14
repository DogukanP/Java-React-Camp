package com.padel.HRMS.business.concretes;

import com.padel.HRMS.business.abstracts.UserService;
import com.padel.HRMS.dataAccess.abstracts.UserDao;
import com.padel.HRMS.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }
}
