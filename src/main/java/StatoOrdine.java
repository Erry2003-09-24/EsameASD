public enum StatoOrdine {
    IN_PREPARAZIONE,
    PRONTO,
    CONSEGNATO;

    @Override
    public String toString() {
        switch (this) {
            case IN_PREPARAZIONE: return "In preparazione";
            case PRONTO: return "Pronto";
            case CONSEGNATO: return "Consegnato";
            default: return super.toString();
        }
    }
}
