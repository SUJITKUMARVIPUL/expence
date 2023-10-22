package com.sujit.expenceTracker.repo;

import com.sujit.expenceTracker.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Integer> {
}
