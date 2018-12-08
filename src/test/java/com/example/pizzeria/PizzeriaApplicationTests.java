package com.example.pizzeria;

import com.example.pizzeria.model.Bill;
import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.PizzeriaRepository;
import com.example.pizzeria.service.PizzeriaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@Profile("test")
public class PizzeriaApplicationTests {

    @Mock
    private PizzeriaRepository pizzeriaRepository;

    private final List<Long> pizzaIds = Arrays.asList(1L, 2L, 3L);

    final Pizza margherita = new Pizza(1L, "Margherita", "desc 1", 5.);
    final Pizza napoli = new Pizza(2L, "Napoli", "desc 2", 5.5);
    final Pizza diavola = new Pizza(3L, "Diavola", "desc 3", 7.);

    private final List<Pizza> pizzas = Arrays.asList(margherita, napoli, diavola);


    private PizzeriaService pizzeriaService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Before
    public void initPizzeria() {

        this.pizzeriaRepository = Mockito.mock(PizzeriaRepository.class);

        Mockito.when(pizzeriaRepository.findAllById(pizzaIds))
                .thenReturn(pizzas);

        this.pizzeriaService = new PizzeriaService(this.pizzeriaRepository);

    }

    @Test
    public void billTest() {

        Bill testBill = pizzeriaService.getBill(pizzaIds);

        assertEquals(testBill.getPizzaNames(), pizzas.stream().map(Pizza::getName).collect(Collectors.toList()));
        assertEquals(testBill.getTotalPrice(), 17.5, 0);

    }

}
