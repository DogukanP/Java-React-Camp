package com.padel;

public class Main {

    public static void main(String[] args) {
        IndividualCustomer dogukan = new IndividualCustomer();
        dogukan.id = 1;
        dogukan.customerNumber ="123456789";
        dogukan.firstName = "Dogukan";
        dogukan.lastName = "Padel";

        CorporateCustomer kodlamaIO = new CorporateCustomer();
        kodlamaIO.companyName = "Kodlama.IO";
        kodlamaIO.id= 2;
        kodlamaIO.customerNumber="123456780";
        kodlamaIO.taxNumber ="123456";

        SendikaCustomer abc = new SendikaCustomer();
        abc.customerNumber = "1234587";

        CustomerManager customerManager = new CustomerManager();
        /*customerManager.add(dogukan);
        customerManager.add(kodlamaIO);
        customerManager.add(abc);*/

        Customer[] customers = {dogukan,kodlamaIO,abc};
        customerManager.addMultiple(customers);
    }
}
