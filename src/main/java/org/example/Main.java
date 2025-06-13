package org.example;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Cliente> clienti = new ArrayList<>();
    private static List<Pizza> pizze = new ArrayList<>();
    private static List<Ordine> ordini = new ArrayList<>();
    private static int ordineCounter = 1;

    public static void main(String[] args) {
        clienti.add(new Cliente("C001", "Mario", "Rossi", "3331234567",
                new Indirizzo("Via Roma", "10", "00100", "Roma")));
        clienti.add(new Cliente("C002", "Luca", "Bianchi", "3337654321",
                new Indirizzo("Via Milano", "5", "20100", "Milano")));

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserisci pizza");
            System.out.println("2 - Inserisci ordine");
            System.out.println("3 - Aggiorna stato ordine");
            System.out.println("4 - Visualizza ordini");
            System.out.println("5 - Esci");
            System.out.print("Scegli: ");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1": inserisciPizza(); break;
                case "2": inserisciOrdine(); break;
                case "3": aggiornaStatoOrdine(); break;
                case "4": visualizzaOrdini(); break;
                case "5":
                    running = false;
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }

    private static void inserisciPizza() {
        System.out.print("Nome pizza: ");
        String nome = scanner.nextLine();
        System.out.print("Ingredienti (separati da virgola): ");
        List<String> ingredienti = Arrays.asList(scanner.nextLine().split(","));
        ingredienti.replaceAll(String::trim);
        System.out.print("Prezzo: ");
        double prezzo = Double.parseDouble(scanner.nextLine());

        Pizza pizza = new Pizza(nome, prezzo);
        pizze.add(pizza);
        System.out.println("Pizza inserita.");
    }

    private static void inserisciOrdine() {
        System.out.print("Codice cliente: ");
        String codiceCliente = scanner.nextLine();

        Optional<Cliente> clienteOpt = clienti.stream()
                .filter(c -> c.getCodiceCliente().equalsIgnoreCase(codiceCliente))
                .findFirst();

        if (!clienteOpt.isPresent()) {
            System.out.println("Cliente non trovato.");
            return;
        }

        if (pizze.isEmpty()) {
            System.out.println("Non ci sono pizze disponibili.");
            return;
        }

        System.out.println("Pizze disponibili:");
        for (Pizza p : pizze) {
            System.out.println("- " + p.getNome());
        }

        System.out.print("Inserisci nomi pizze da ordinare (separati da virgola): ");
        String line = scanner.nextLine();
        List<String> nomiPizze = Arrays.asList(line.split(","));
        nomiPizze.replaceAll(String::trim);

        List<Pizza> pizzeOrdinate = new ArrayList<>();
        for (String nomePizza : nomiPizze) {
            pizze.stream()
                    .filter(p -> p.getNome().equalsIgnoreCase(nomePizza))
                    .findFirst()
                    .ifPresent(pizzeOrdinate::add);
        }

        if (pizzeOrdinate.isEmpty()) {
            System.out.println("Nessuna pizza valida selezionata.");
            return;
        }

        Ordine ordine = new Ordine(ordineCounter++, codiceCliente, pizzeOrdinate);
        ordini.add(ordine);
        System.out.println("Ordine inserito:\n" + ordine);
    }

    private static void aggiornaStatoOrdine() {
        System.out.print("Numero ordine da aggiornare: ");
        int numero = Integer.parseInt(scanner.nextLine());

        Optional<Ordine> ordineOpt = ordini.stream()
                .filter(o -> o.getNumeroOrdine() == numero)
                .findFirst();

        if (!ordineOpt.isPresent()) {
            System.out.println("Ordine non trovato.");
            return;
        }

        System.out.println("Stati possibili:");
        for (StatoOrdine s : StatoOrdine.values()) {
            System.out.println("- " + s);
        }
        System.out.print("Inserisci nuovo stato (esatto): ");
        String statoStr = scanner.nextLine();

        try {
            StatoOrdine nuovoStato = StatoOrdine.valueOf(statoStr.toUpperCase());
            ordineOpt.get().setStato(nuovoStato);
            System.out.println("Stato aggiornato:\n" + ordineOpt.get());
        } catch (IllegalArgumentException e) {
            System.out.println("Stato non valido.");
        }
    }

    private static void visualizzaOrdini() {
        if (ordini.isEmpty()) {
            System.out.println("Nessun ordine presente.");
            return;
        }
        for (Ordine o : ordini) {
            System.out.println(o);
            System.out.println("----------------------");
        }
    }
}
