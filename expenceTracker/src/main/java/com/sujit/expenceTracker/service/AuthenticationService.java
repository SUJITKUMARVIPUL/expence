package com.sujit.expenceTracker.service;

import com.sujit.expenceTracker.model.AuthenticationToken;
import com.sujit.expenceTracker.repo.IAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationTokenRepo authenticationRepo;
    public void addAuthentication(AuthenticationToken token){
        authenticationRepo.save(token);
    }

    public boolean Authenticate(String Email,String TokenValue){
        AuthenticationToken token = authenticationRepo.findFirstByTokenValue(TokenValue);
        if(token!=null){
            return token.getUser().getEmail().equals(Email);
        }else {
            return false;
        }
    }

    public void deleteToken(String tokenValue) {
        AuthenticationToken token = authenticationRepo.findFirstByTokenValue(tokenValue);
        authenticationRepo.delete(token);
    }
}
