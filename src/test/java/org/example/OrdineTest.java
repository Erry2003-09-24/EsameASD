package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdineTest {

    @Test
    void testCostruttoreCalcolaTotale() {
        Pizza margherita = new Pizza("Margherita", List.of("pomodoro", "mozzarella"), 5.0);
        Pizza diavola = new Pizza("Diavola", List.of("pomodoro", "salame piccante"), 7.5);

        Ordine ordine = new Ordine(1, "C123", List.of(margherita, diavola));

        assertEquals(12.5, ordine.getTotale(), 0.001);
        assertEquals(1, ordine.getNumeroOrdine());
        assertEquals("C123", ordine.getCodiceCliente());
        assertEquals(StatoOrdine.IN_PREPARAZIONE, ordine.getStato());
        assertNotNull(ordine.getDataOra());
    }

    @Test
    void testSettersAndGetters() {
        Pizza margherita = new Pizza("Margherita", List.of("pomodoro", "mozzarella"), 5.0);
        Pizza diavola = new Pizza("Diavola", List.of("pomodoro", "salame piccante"), 7.5);
        Ordine ordine = new Ordine(1, "C123", List.of(margherita));

        ordine.setNumeroOrdine(99);
        assertEquals(99, ordine.getNumeroOrdine());

        ordine.setCodiceCliente("C999");
        assertEquals("C999", ordine.getCodiceCliente());

        ordine.setPizze(List.of(diavola));
        assertEquals(1, ordine.getPizze().size());
        assertEquals("Diavola", ordine.getPizze().get(0).getNome());
        assertEquals(7.5, ordine.getTotale(), 0.001);

        ordine.setStato(StatoOrdine.CONSEGNATO);
        assertEquals(StatoOrdine.CONSEGNATO, ordine.getStato());

        LocalDateTime now = LocalDateTime.now();
        ordine.setDataOra(now);
        assertEquals(now, ordine.getDataOra());
    }

    @Test
    void testToStringContieneInfo() {
        Pizza margherita = new Pizza("Margherita", List.of("pomodoro", "mozzarella"), 5.0);
        Ordine ordine = new Ordine(3, "C789", List.of(margherita));

        String output = ordine.toString();

        assertTrue(output.contains("Ordine #3"));
        assertTrue(output.contains("Cliente: C789"));
        assertTrue(output.contains("Margherita"));
        assertTrue(output.contains("Totale: €5.00"));
        assertTrue(output.contains("IN_PREPARAZIONE"));
    }
}
