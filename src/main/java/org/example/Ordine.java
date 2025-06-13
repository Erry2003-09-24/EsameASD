package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Ordine {
    private int numeroOrdine; //numero ordine
    private String codiceCliente;
    private List<Pizza> pizze;
    private double totale;
    private StatoOrdine stato;
    private LocalDateTime dataOra;

    public Ordine(int numeroOrdine, String codiceCliente, List<Pizza> pizze) {
        this.numeroOrdine = numeroOrdine;
        this.codiceCliente = codiceCliente;
        this.pizze = pizze;
        this.totale = pizze.stream().mapToDouble(Pizza::getPrezzo).sum();
        this.stato = StatoOrdine.IN_PREPARAZIONE;
        this.dataOra = LocalDateTime.now();
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(int numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public List<Pizza> getPizze() {
        return pizze;
    }

    public void setPizze(List<Pizza> pizze) {
        this.pizze = pizze;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordine #").append(numeroOrdine)
                .append("\nCliente: ").append(codiceCliente)
                .append("\nData/Ora: ").append(dataOra)
                .append("\nStato: ").append(stato)
                .append("\nTotale: €").append(String.format("%.2f", totale))
                .append("\nPizze ordinate:\n");
        for (Pizza p : pizze) {
            sb.append("  - ").append(p).append("\n");
        }
        return sb.toString();
    }
}
