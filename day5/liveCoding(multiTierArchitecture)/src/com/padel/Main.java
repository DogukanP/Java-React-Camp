package com.padel;


import com.padel.business.abstracts.ProductService;
import com.padel.business.concretes.ProductManager;
import com.padel.core.JLoggerManagerAdapter;
import com.padel.dataAccess.concretes.AbcProductDao;
import com.padel.entities.concretes.Product;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductManager(new AbcProductDao(),new JLoggerManagerAdapter());

        Product product = new Product(1,2,"laptop",10000,20);
        productService.add(product);
    }
}
