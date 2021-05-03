package com.padel;

public class Main {

    public static void main(String[] args) {
        Customer dogukan = new Customer(1,"Dogukan","Padel");
        Logger[] loggers = {new EmailLogger(),new SmsLogger(),new FileLogger()};
	    CustomerManager customerManager = new CustomerManager(loggers);
	    customerManager.add(dogukan);
    }
}
