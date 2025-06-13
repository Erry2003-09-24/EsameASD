package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdineTest {

    @Test
    void testCostruttoreCalcolaTotale() {
        Pizza margherita = new Pizza("Margherita", 5.0);
        Pizza diavola = new Pizza("Diavola", 7.5);

        Ordine ordine = new Ordine(1, "C123", List.of(margherita, diavola));

        // Verifica il totale calcolato
        assertEquals(12.5, ordine.getPizze().stream().mapToDouble(Pizza::getPrezzo).sum(), 0.001);
        // Numero ordine
        assertEquals(1, ordine.getNumeroOrdine());
        // Codice cliente
        assertEquals("C123", ordine.getCodiceCliente());
        // Stato iniziale
        assertEquals(StatoOrdine.IN_PREPARAZIONE, ordine.getStato());
        // Data/Ora non null
        assertNotNull(ordine.getDataOra());
    }

    @Test
    void testSettersAndGetters() {
        Pizza margherita = new Pizza("Margherita", 5.0);
        Pizza diavola = new Pizza("Diavola", 7.5);
        Ordine ordine = new Ordine(1, "C123", List.of(margherita));

        // Cambia numero ordine
        ordine.setNumeroOrdine(99);
        assertEquals(99, ordine.getNumeroOrdine());

        // Cambia codice cliente
        ordine.setCodiceCliente("C999");
        assertEquals("C999", ordine.getCodiceCliente());

        // Cambia lista pizze
        ordine.setPizze(List.of(diavola));
        assertEquals(1, ordine.getPizze().size());
        assertEquals("Diavola", ordine.getPizze().get(0).toString().split(" ")[0]);

        // Cambia stato
        ordine.setStato(StatoOrdine.CONSEGNATO);
        assertEquals(StatoOrdine.CONSEGNATO, ordine.getStato());

        // Cambia dataOra
        LocalDateTime now = LocalDateTime.now();
        ordine.setDataOra(now);
        assertEquals(now, ordine.getDataOra());
    }

    @Test
    void testToStringContieneInfo() {
        Pizza margherita = new Pizza("Margherita", 5.0);
        Ordine ordine = new Ordine(3, "C789", List.of(margherita));
        String output = ordine.toString();

        assertTrue(output.contains("Ordine #3"));
        assertTrue(output.contains("Cliente: C789"));
        assertTrue(output.contains("Margherita"));
        assertTrue(output.contains("Totale: €5.00"));
        assertTrue(output.contains("IN_PREPARAZIONE"));
    }
}
