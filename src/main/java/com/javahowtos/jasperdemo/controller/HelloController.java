package com.javahowtos.jasperdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class HelloController {
    @GetMapping({"/", "/form"})
    public String hello() {
        return "form";
    }
    
}
