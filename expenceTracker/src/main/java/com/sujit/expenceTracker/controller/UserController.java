package com.sujit.expenceTracker.controller;

import com.sujit.expenceTracker.model.Product;
import com.sujit.expenceTracker.model.User;
import com.sujit.expenceTracker.service.ProductService;
import com.sujit.expenceTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;


    @PostMapping("/register")
    public String addUser(@RequestBody User user){
        return userService.userSignUp(user);
    }

    @PostMapping("/signIn")
    public String signIn(@RequestParam String Email,@RequestParam String Password){
        return userService.userSignIn(Email,Password);
    }

    @PostMapping("/user/product")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
