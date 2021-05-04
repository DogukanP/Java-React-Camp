package com.padel.Concrete;

import com.padel.Abstract.CustomerCheckService;
import com.padel.Abstract.CustomerService;
import com.padel.Entities.Customer;
import com.padel.Entities.User;

public class CustomerManager implements CustomerService{
    CustomerCheckService customerCheckService;

    public CustomerManager(final CustomerCheckService customerCheckService) {
        this.customerCheckService = customerCheckService;
    }

    @Override
    public void login(Customer customer) {
        if(customerCheckService.isRealPerson(customer)){
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " başarıyla kayıt oldu.");
        }else {
            System.out.println("Hatalı doğrulama");
        }
    }

    @Override
    public void edit(Customer customer) {
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " başarıyla güncellendi.");
    }

    @Override
    public void delete(Customer customer) {
        System.out.println(customer.getFirstName() + " " + customer.getLastName() + " başarıyla silindi.");
    }
}
