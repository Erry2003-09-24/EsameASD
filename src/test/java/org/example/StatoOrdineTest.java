package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatoOrdineTest {

    @Test
    void testEnumValues() {
        StatoOrdine[] stati = StatoOrdine.values();
        assertEquals(3, stati.length);
        assertEquals(StatoOrdine.IN_PREPARAZIONE, stati[0]);
        assertEquals(StatoOrdine.PRONTO, stati[1]);
        assertEquals(StatoOrdine.CONSEGNATO, stati[2]);
    }

    @Test
    void testToString() {
        assertEquals("In preparazione", StatoOrdine.IN_PREPARAZIONE.toString());
        assertEquals("Pronto", StatoOrdine.PRONTO.toString());
        assertEquals("Consegnato", StatoOrdine.CONSEGNATO.toString());
    }
}
