package com.padel.northwind.business.concretes;

import com.padel.northwind.business.abstracts.ProductService;
import com.padel.northwind.core.utilities.results.DataResult;
import com.padel.northwind.core.utilities.results.Result;
import com.padel.northwind.core.utilities.results.SuccessDataResult;
import com.padel.northwind.core.utilities.results.SuccessResult;
import com.padel.northwind.dataAccess.abstracts.ProductDao;
import com.padel.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }
}
