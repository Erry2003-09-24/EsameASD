package org.example;

import java.util.List;
import java.util.ArrayList;

// Class for represent a Pizza
public class Pizza {
    private String nome;
    private List<String> ingredienti;
    private double prezzo;

    // Costruttore completo
    public Pizza(String nome, List<String> ingredienti, double prezzo) {
        this.nome = nome;
        this.ingredienti = ingredienti != null ? ingredienti : new ArrayList<>();
        this.prezzo = prezzo;
    }

    // Costruttore solo con nome e prezzo, ingredienti vuoti
    public Pizza(String nome, double prezzo) {
        this(nome, new ArrayList<>(), prezzo);
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
        this.ingredienti = ingredienti != null ? ingredienti : new ArrayList<>();
    }

    @Override
    public String toString() {
        return nome + " (" + String.join(", ", ingredienti) + ") - €" + prezzo;
    }
}
