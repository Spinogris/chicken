package com.chicken.de.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/signin")
    public String account(Model model){
        return "signin";
    }
}
