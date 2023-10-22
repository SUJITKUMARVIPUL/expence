package com.sujit.expenceTracker.repo;

import com.sujit.expenceTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String email);

}
