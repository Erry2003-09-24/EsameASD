package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void testCostruttoreCompleto() {
        List<String> ingredienti = List.of("pomodoro", "mozzarella", "basilico");
        Pizza pizza = new Pizza("Margherita", ingredienti, 5.0);

        assertEquals("Margherita", pizza.getNome());
        assertEquals(5.0, pizza.getPrezzo());
        assertEquals(ingredienti, pizza.getIngredienti());
    }

    @Test
    void testCostruttoreNomePrezzo() {
        Pizza pizza = new Pizza("Diavola", 7.5);

        assertEquals("Diavola", pizza.getNome());
        assertEquals(7.5, pizza.getPrezzo());
        assertNotNull(pizza.getIngredienti());
        assertTrue(pizza.getIngredienti().isEmpty());
    }

    @Test
    void testSettersAndGetters() {
        Pizza pizza = new Pizza("Funghi", 6.0);

        pizza.setNome("Quattro Stagioni");
        assertEquals("Quattro Stagioni", pizza.getNome());

        pizza.setPrezzo(8.5);
        assertEquals(8.5, pizza.getPrezzo());

        List<String> ingredienti = new ArrayList<>();
        ingredienti.add("funghi");
        ingredienti.add("prosciutto");
        pizza.setIngredienti(ingredienti);
        assertEquals(ingredienti, pizza.getIngredienti());
    }

    @Test
    void testToString() {
        List<String> ingredienti = List.of("pomodoro", "mozzarella");
        Pizza pizza = new Pizza("Margherita", ingredienti, 5.0);

        String expected = "Margherita (pomodoro, mozzarella) - €5.0";
        assertEquals(expected, pizza.toString());
    }

    @Test
    void testToStringIngredientiVuoti() {
        Pizza pizza = new Pizza("Bianca", 4.5);

        String expected = "Bianca () - €4.5";
        assertEquals(expected, pizza.toString());
    }
}
