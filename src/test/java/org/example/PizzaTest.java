package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void testCostruttoreInizializzaNomeEPrezzo() {
        Pizza pizza = new Pizza("Margherita", 5.0);
        assertEquals("Margherita", pizza.getNome());
        assertEquals(5.0, pizza.getPrezzo());
        assertNull(pizza.getIngredienti());
    }

    @Test
    void testSettersEGetters() {
        Pizza pizza = new Pizza("Margherita", 5.0);

        pizza.setNome("Diavola");
        assertEquals("Diavola", pizza.getNome());

        pizza.setPrezzo(7.5);
        assertEquals(7.5, pizza.getPrezzo());

        List<String> ingredienti = List.of("pomodoro", "mozzarella", "salame piccante");
        pizza.setIngredienti(ingredienti);
        assertEquals(ingredienti, pizza.getIngredienti());
    }

    @Test
    void testToStringConIngredienti() {
        Pizza pizza = new Pizza("Margherita", 5.0);
        pizza.setIngredienti(List.of("pomodoro", "mozzarella"));

        String descrizione = pizza.toString();
        assertTrue(descrizione.contains("Margherita"));
        assertTrue(descrizione.contains("pomodoro"));
        assertTrue(descrizione.contains("mozzarella"));
        assertTrue(descrizione.contains("€5.0") || descrizione.contains("€5.00"));
    }

    @Test
    void testToStringConIngredientiNull() {
        Pizza pizza = new Pizza("Margherita", 5.0);
        pizza.setIngredienti(null);

        assertThrows(NullPointerException.class, pizza::toString);
    }
}
