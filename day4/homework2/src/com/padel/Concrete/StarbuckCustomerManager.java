package com.padel.Concrete;

import com.padel.Abstract.BaseCustomerManager;
import com.padel.Abstract.CustomerCheckService;
import com.padel.Entities.Customer;

public class StarbuckCustomerManager extends BaseCustomerManager {
    CustomerCheckService customerCheckService;

    public StarbuckCustomerManager(CustomerCheckService customerCheckService){
        this.customerCheckService = customerCheckService;
    }

    @Override
    public void save(Customer customer){
        if(customerCheckService.personIsReal(customer)){
            System.out.println("Starbucks Manager : Doğrulama başarılı.");
            super.save(customer);
        }
        else {
            System.out.println("Starbucks Manager : Doğrulama hatası.");
        }
    }
}
