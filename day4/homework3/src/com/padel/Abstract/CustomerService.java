package com.padel.Abstract;

import com.padel.Entities.Customer;
import com.padel.Entities.User;

public interface CustomerService {
    void login(Customer customer);
    void edit(Customer customer);
    void delete(Customer customer);
}
