package cz.upce.bdats.sema.autopujcovna;

public abstract class Auto {
    // Atributy
    private final Typ typ;
    private final String spz;
    private float stavKm = 0;
    private int pocetVypujceni = 0;

    // Konstruktor
    public Auto(Typ typ, String spz) {
        this.typ = typ;
        this.spz = spz;
    }

    // Metody
    @Override
    public String toString() {
        return String.format("%s: %s; %.2f km, vypůjčeno %dx", typ, spz, stavKm, pocetVypujceni);
    }

    // Gettery
    public String getSPZ() {
        return spz;
    }

    public float getStavKm() {
        return stavKm;
    }

    public int getPocetVypujceni() {
        return pocetVypujceni;
    }

    public AutoTyp getTyp() {
        return typ;
    }

    // Settery
    public void setStavKm(float km) {
        stavKm = km;
    }

    public void setPocetVypujceni(int pocetVypujceni) {
        this.pocetVypujceni = pocetVypujceni;
    }
}