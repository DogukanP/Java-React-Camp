package com.padel.Abstract;

import com.padel.Entities.Customer;


public abstract class BaseCustomerManager implements CustomerService{
    @Override
    public  void save(Customer customer){
        System.out.println(customer.getFirstName() + " veri tabanına kaydedildi.");
    }
}
