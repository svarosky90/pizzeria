package com.example.pizzeria.controller;

import com.example.pizzeria.model.Bill;
import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PizzeriaController {


    private PizzeriaService pizzeriaService;

    @Autowired
    public PizzeriaController(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/menu")
    public ResponseEntity<List<Pizza>> getMenu() {

        Optional<List<Pizza>> optionalPizzas = Optional.ofNullable(pizzeriaService.getMenu());

        if (optionalPizzas.isPresent()) {
            return ResponseEntity.ok(optionalPizzas.get());
        }

        return ResponseEntity.notFound().build();

    }


    @RequestMapping(method = RequestMethod.GET, path = "/bill")
    public ResponseEntity<Bill> getMenu(@RequestParam("pizzaIds") List<Long> pizzaIds) {

        return ResponseEntity.ok(pizzeriaService.getBill(pizzaIds));


    }


}
