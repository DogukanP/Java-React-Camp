package com.padel.northwind.business.abstracts;

import com.padel.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

}
