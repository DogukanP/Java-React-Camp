package com.padel.HRMS.business.abstracts;

import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.core.utilities.results.Result;
import com.padel.HRMS.entities.concretes.User;

import java.util.List;

public interface UserService{
    DataResult<List<User>> getAll();
    User add(User user);
}
