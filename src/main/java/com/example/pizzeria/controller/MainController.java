package com.example.pizzeria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public ResponseEntity healtCheck() {
        return ResponseEntity.ok().build();
    }


}
