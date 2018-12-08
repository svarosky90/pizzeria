package com.example.pizzeria.model;

import java.util.List;

public class Bill {

    List<String> pizzaNames;
    private Double totalPrice;

    public Bill(List<String> pizzaNames, Double totalPrice) {
        this.pizzaNames = pizzaNames;
        this.totalPrice = totalPrice;
    }

    public List<String> getPizzaNames() {
        return pizzaNames;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
