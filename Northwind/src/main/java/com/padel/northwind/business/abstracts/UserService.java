package com.padel.northwind.business.abstracts;

import com.padel.northwind.core.entities.User;
import com.padel.northwind.core.utilities.results.DataResult;
import com.padel.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
