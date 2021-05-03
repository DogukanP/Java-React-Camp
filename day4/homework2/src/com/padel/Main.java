package com.padel;

import com.padel.Abstract.BaseCustomerManager;
import com.padel.Adapters.MernisServiceAdapter;
import com.padel.Concrete.NeroCustomerManager;
import com.padel.Concrete.StarbuckCustomerManager;
import com.padel.Entities.Customer;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Customer dogukan = new Customer(1,"Doğukan","Padel",new Date(1999,4,8),"33601767980");
        BaseCustomerManager customerManager = new StarbuckCustomerManager(new MernisServiceAdapter());
        //BaseCustomerManager customerManager = new NeroCustomerManager();
        customerManager.save(dogukan);
    }
}
