package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void testGetCodiceCliente() {
        Indirizzo indirizzo = new Indirizzo("Via Roma", "10", "00100", "Roma");
        Cliente cliente = new Cliente("C123", "Mario", "Rossi", "1234567890", indirizzo);

        assertEquals("C123", cliente.getCodiceCliente());
    }

    @Test
    public void testToString() {
        Indirizzo indirizzo = new Indirizzo("Via Roma", "10", "00100", "Roma");
        Cliente cliente = new Cliente("C123", "Mario", "Rossi", "1234567890", indirizzo);

        String expected = "C123: Mario Rossi, Tel: 1234567890, Indirizzo: " + indirizzo.toString();
        assertEquals(expected, cliente.toString());
    }
}
