package cz.upce.bdats.sema.autopujcovna;

public enum EnumPozice {
    // Prvky
    PRVNI("první"),
    POSLEDNI("poslední"),
    AKTUALNI("aktuální"),
    PREDCHUDCE("předchůdce"),
    NASLEDNIK("následník");

    // Atributy
    private final String nazev;

    // Konstruktor
    private EnumPozice(String nazev) {
        this.nazev = nazev;
    }

    // Metody
    @Override
    public String toString() {
        return nazev;
    }

    // Gettery
    public String getNazev() {
        return nazev;
    }
}