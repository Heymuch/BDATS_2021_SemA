package cz.upce.bdats.sema.autopujcovna;

public class UzitkoveAuto extends Auto {
    // Atributy
    private final float nosnost;

    // Kontruktor
    public UzitkoveAuto(String spz, float nosnost) {
        super(Typ.UZITKOVY, spz);
        this.nosnost = nosnost;
    }

    // Metody
    @Override
    public String toString() {
        return String.format("%s, nosnost: %.2f", super.toString(), nosnost);
    }

    // Gettery
    public float getNosnost() {
        return nosnost;
    }
}