package com.padel.northwind.dataAccess.abstracts;

import com.padel.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer>{
}
