package com.pravin.accounts.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccountsControllers {

    @GetMapping("hello")
    public String hello(){
        return "Hello world Pravin swain";
    }
}
