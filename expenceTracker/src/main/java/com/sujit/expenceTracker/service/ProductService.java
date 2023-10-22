package com.sujit.expenceTracker.service;

import com.sujit.expenceTracker.model.Product;
import com.sujit.expenceTracker.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo productRepo;

    public String addProduct(Product product){
        productRepo.save(product);
        return "Product added successful";
    }
}
