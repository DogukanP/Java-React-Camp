package com.padel.Concrete;

import com.padel.Abstract.CustomerCheckService;
import com.padel.Adapters.ValidationService;
import com.padel.Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {
    @Override
    public boolean isRealPerson(Customer customer) {
        return true;
    }
}
