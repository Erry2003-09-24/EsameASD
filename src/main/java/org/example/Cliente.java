package org.example;

public class Cliente {
    private String codiceCliente;
    private String nome;
    private String cognome;
    private String telefono;
    private Indirizzo indirizzo;

    public Cliente(String codiceCliente, String nome, String cognome, String telefono, Indirizzo indirizzo) {
        this.codiceCliente = codiceCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    @Override
    public String toString() {
        return codiceCliente + ": " + nome + " " + cognome + ", Tel: " + telefono + ", Indirizzo: " + indirizzo;
    }
}
