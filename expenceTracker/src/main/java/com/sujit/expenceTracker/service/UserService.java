package com.sujit.expenceTracker.service;

import com.sujit.expenceTracker.model.AuthenticationToken;
import com.sujit.expenceTracker.model.User;
import com.sujit.expenceTracker.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    public String userSignUp(User user){
        User newUser = userRepo.findFirstByEmail(user.getEmail());
        if(user!=null){
            return "Email already registered";
        }
        try {
            String password = PasswordEncryption.encrypt(user.getPassword());
            user.setPassword(password);
            userRepo.save(user);
            return "Registration Successful";
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String userSignIn(String Email,String Password){
        User user = userRepo.findFirstByEmail(Email);
        if(user==null){
            return "Email not Registered";
        }
        try {
            String EncryptPass = PasswordEncryption.encrypt(Password);
            if (user.getPassword().equals(EncryptPass)) {
                AuthenticationToken token = new AuthenticationToken(user);
                authenticationService.addAuthentication(token);
                return "SignIn Successful";
            }else {
                return "Password Wrong";
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String userSignOut(String email,String tokenValue) {
        if(authenticationService.Authenticate(email,tokenValue)) {
            authenticationService.deleteToken(tokenValue);
            return "Sign Out successful!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }


}
