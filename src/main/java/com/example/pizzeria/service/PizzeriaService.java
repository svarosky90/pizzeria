package com.example.pizzeria.service;

import com.example.pizzeria.model.Bill;
import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzeriaService {

    private PizzeriaRepository pizzeriaRepository;

    @Autowired
    public PizzeriaService(PizzeriaRepository pizzeriaRepository) {
        this.pizzeriaRepository = pizzeriaRepository;
    }

    public List<Pizza> getMenu() {

        return pizzeriaRepository.findAll();

    }


    public Bill getBill(List<Long> pizzaIds) {

        final List<Pizza> pizzas = pizzeriaRepository.findAllById(pizzaIds);

        final List<String> pizzaNames = pizzas.stream().map(Pizza::getName).collect(Collectors.toList());
        final Double totalPrice = pizzas.stream().mapToDouble(Pizza::getPrice).sum();

        return new Bill(pizzaNames, totalPrice);

    }
}
