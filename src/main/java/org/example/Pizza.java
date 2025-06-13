package org.example;

import java.util.List;

public class Pizza {
    private String nome;
    private List<String> ingredienti;
    private double prezzo;

    public Pizza(String nome, double prezzo) {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public List<String> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(List<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return nome + " (" + String.join(", ", ingredienti) + ") - €" + prezzo;
    }
}
