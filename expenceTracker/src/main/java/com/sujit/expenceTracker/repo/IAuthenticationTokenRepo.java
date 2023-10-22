package com.sujit.expenceTracker.repo;

import com.sujit.expenceTracker.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationTokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findFirstByTokenValue(String tokenValue);

}
