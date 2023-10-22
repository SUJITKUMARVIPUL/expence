package com.sujit.expenceTracker.repo;

import com.sujit.expenceTracker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Integer> {
}
