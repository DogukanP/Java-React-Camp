package com.padel.northwind.business.abstracts;

import com.padel.northwind.core.utilities.results.DataResult;
import com.padel.northwind.core.utilities.results.Result;
import com.padel.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
}
