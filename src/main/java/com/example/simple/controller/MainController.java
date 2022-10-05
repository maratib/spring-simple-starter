package com.example.simple.controller;

import com.example.simple.dto.AuthDto;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class MainController {

    @GetMapping(value = "")
    public String getHome() {
        return "Simple-Starter";
    }

    @PostMapping(value = "")

    public String postUserAuth(@Valid @RequestBody AuthDto userAuth) {

        return "Posted";
    }

}
