package com.padel.Abstract;

import com.padel.Entities.Customer;

public interface CustomerCheckService {
    boolean isRealPerson(Customer customer);
}
