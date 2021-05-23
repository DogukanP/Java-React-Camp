package com.padel.northwind.dataAccess.abstracts;

import com.padel.northwind.core.utilities.results.DataResult;
import com.padel.northwind.core.utilities.results.Result;
import com.padel.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer>{

}
