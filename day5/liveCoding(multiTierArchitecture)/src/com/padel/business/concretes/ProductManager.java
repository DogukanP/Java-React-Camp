package com.padel.business.concretes;

import com.padel.business.abstracts.ProductService;
import com.padel.core.LoggerService;
import com.padel.dataAccess.abstracts.ProductDao;
import com.padel.dataAccess.concretes.HibernateProductDao;
import com.padel.entities.concretes.Product;
import com.padel.jLogger.JLoggerManager;

import java.util.List;

public class ProductManager implements ProductService {

    private ProductDao productDao;
    private LoggerService loggerService;

    public ProductManager(ProductDao productDao,LoggerService loggerService) {
        this.productDao = productDao;
        this.loggerService = loggerService;
    }
    @Override
    public void add(Product product) {
        if(product.getCategoryId()==1){
            System.out.println("Bu kategoride ürün kabul edilmiyor.");
            return;
        }
        this.productDao.add(product);
        this.loggerService.logToSystem(product.getName() + " eklendi");
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
