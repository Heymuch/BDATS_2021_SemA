package cz.upce.bdats.sema.autopujcovna;

public class OsobniAuto extends Auto {
    // Atributy
    private final Barva barva;

    // Konstruktor
    public OsobniAuto(String spz, Barva barva) {
        super(Typ.OSOBNI, spz);
        this.barva = barva;
    }

    // Metody
    @Override
    public String toString() {
        return String.format("%s, barva: %s", super.toString(), barva);
    }

    // Gettery
    public Barva getBarva() {
        return barva;
    }
}