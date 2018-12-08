package com.example.pizzeria.repository;

import com.example.pizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzeriaRepository extends JpaRepository<Pizza, Long> {
}
