package com.suglobov.jackal.rest.controller;

import com.suglobov.jackal.rest.model.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Cactus3D on 04.04.2017.
 */
@Controller
public class MainController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String enter(Model model){
        model.addAttribute("formData", new Main());
        //model.addAttribute("arc", new Arc());
        return "main";
    }
}
