package com.padel.Concrete;

import com.padel.Abstract.CustomerCheckService;
import com.padel.Entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {


    @Override
    public boolean personIsReal(Customer customer) {
        return true;
    }
}
