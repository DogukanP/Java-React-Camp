package com.padel.dataAccess.concretes;

import com.padel.dataAccess.abstracts.ProductDao;
import com.padel.entities.concretes.Product;

import java.util.List;

public class AbcProductDao implements ProductDao {

    @Override
    public void add(Product product) {
        System.out.println(product.getName() + ", abc ile eklendi.");
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
