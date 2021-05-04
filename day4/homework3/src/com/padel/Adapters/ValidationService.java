package com.padel.Adapters;

import com.padel.Abstract.CustomerCheckService;
import com.padel.Entities.Customer;

public class ValidationService implements CustomerCheckService {
    @Override
    public boolean isRealPerson(Customer customer) {
        if(!customer.getNationalId().isEmpty()){
            return true;
        }else return false;
    }
}
