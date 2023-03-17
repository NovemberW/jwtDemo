package de.axitera.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//@RequestMapping("api/v1/hc")
@RestController
@RequestMapping("/api/v1/hc")
public class HomeController {

    @GetMapping
    public String endpoint(Principal principal){
        return "Hello Controller:" +  principal.getName();
    }
}
