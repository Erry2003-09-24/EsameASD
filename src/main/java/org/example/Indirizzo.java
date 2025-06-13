package org.example;

public class Indirizzo {
    private String via;
    private String numeroCivico;
    private String cap;
    private String citta;
    private String provincia; // provincia per indirizzo

    public Indirizzo(String via, String numeroCivico, String cap, String citta, String provincia) {
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return via + " " + numeroCivico + ", " + cap + " " + citta + " (" + provincia + ")";
    }
}
