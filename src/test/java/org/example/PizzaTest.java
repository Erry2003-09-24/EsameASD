package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class PizzaTest {
    private Pizza margherita;
    private Pizza marinara;

    @Before
    public void setUp() {
        margherita = new Pizza("Margherita", Arrays.asList("Pomodoro", "Mozzarella"), 5.0);
        marinara = new Pizza("Marinara", 4.5); // senza ingredienti
    }

    @Test
    public void testCostruttoreConIngredienti() {
        assertEquals("Margherita", margherita.getNome());
        assertEquals(5.0, margherita.getPrezzo(), 0.01);
        assertEquals(Arrays.asList("Pomodoro", "Mozzarella"), margherita.getIngredienti());
    }

    @Test
    public void testCostruttoreSenzaIngredienti() {
        assertEquals("Marinara", marinara.getNome());
        assertEquals(4.5, marinara.getPrezzo(), 0.01);
        assertTrue(marinara.getIngredienti().isEmpty());
    }

    @Test
    public void testSetters() {
        marinara.setNome("Diavola");
        marinara.setPrezzo(6.0);
        marinara.setIngredienti(Arrays.asList("Pomodoro", "Salame piccante"));

        assertEquals("Diavola", marinara.getNome());
        assertEquals(6.0, marinara.getPrezzo(), 0.01);
        assertEquals(Arrays.asList("Pomodoro", "Salame piccante"), marinara.getIngredienti());
    }

    @Test
    public void testToString() {
        String expected = "Margherita (Pomodoro, Mozzarella) - €5.0";
        assertEquals(expected, margherita.toString());
    }

    @Test
    public void testSetIngredientiNull() {
        margherita.setIngredienti(null);
        assertNotNull(margherita.getIngredienti());
        assertTrue(margherita.getIngredienti().isEmpty());
    }
}
