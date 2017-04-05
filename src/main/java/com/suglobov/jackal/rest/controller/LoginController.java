package com.suglobov.jackal.rest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }
}