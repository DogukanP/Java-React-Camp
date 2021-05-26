package com.padel.HRMS.business.concretes;


import com.padel.HRMS.business.abstracts.UserService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.SuccessDataResult;
import com.padel.HRMS.dataAccess.abstracts.UserDao;
import com.padel.HRMS.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserManager implements UserService {
    @Autowired
    private UserDao userDao;

    public UserManager(){}

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(userDao.findAll(),"Başarılı Şekilde Kullanıcılar Listelendi");
    }

    @Override
    public User add(User user) {
        return userDao.save(user);
    }
}