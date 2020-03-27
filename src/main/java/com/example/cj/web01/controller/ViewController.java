package com.example.cj.web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping(path = {"", "/index"})
    public String index() {
        return "index";
    }
}
