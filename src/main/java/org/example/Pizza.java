package org.example;

import java.util.List;

public class Pizza {
    private String nome;
    private List<String> ingredienti;
    private double prezzo;

    public Pizza(String nome, List<String> ingredienti, double prezzo) {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return nome + " (" + String.join(", ", ingredienti) + ") - €" + prezzo;
    }
}
