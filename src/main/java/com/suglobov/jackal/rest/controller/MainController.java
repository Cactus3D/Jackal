package com.suglobov.jackal.rest.controller;

import com.suglobov.jackal.rest.model.Main;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Cactus3D on 04.04.2017.
 */
@RestController
public class MainController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Main greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Main(counter.incrementAndGet(),
                String.format(template, name));
    }
}
