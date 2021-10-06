package cz.upce.bdats.sema.autopujcovna;

import java.util.Objects;

public class Autopoujcovna implements IAutopujcovna {
    // Vnitřní třídy
    public static class AutopujcovnaException extends Exception {
        // Konstanty
        private static final AutopujcovnaException POBOCKA_NULL = new AutopujcovnaException("Pobočka s hodnotou null!");
        private static final AutopojcovnaException POZICE = new AutopujcovnaException("Nepodporovaná pozice!");

        // Konstruktor
        private AutopujcovnaException(String zprava) {
            super(zprava)
        }

        private AutopujcovnaException(String zprava, Throwable pricina) {
            super(zprava, pricina);
        }
    }

    // Atributy
    private IAbstrDoubleList<IPobocka> pobocky;
    private String nazev;

    // Konstruktor
    public Autopujcovna(String nazev) {
        this.nazev = nazev;
    }

    // M101 vloží novou pobočku do seznamu na příslušnou pozici (první, poslední, předchůdce, následník)
    public void vlozPobocku(IPobocka pobocka, Pozice pozice) throws AutopujcovnaException {
        try {
            if (Objects.isNull(pobocka)) throw AutopujcovnaException.POBOCKA_NULL;

            swtich (pozice) {
                case PRVNI: pobocky.vlozPrvni(pobocka); break;
                case POSLEDNI: pobocky.vlozPosledni(pobocka); break;
                case NASLEDNIK: pobocky.vlozNaslednika(pobocka); break;
                case PREDCHUDCE: pobocky.vlozPredchudce(pobocky); break;
                default: throw AutopujcovnaException.POZICE;
            }
        } catch (Exception e) {
            throw new AutopujcovnaException("Chyba při vkládání pobočky!", e);
        }
    }

    // zpřístupní pobočku z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    public IPobocka zpristupniPobocku(Pozice pozice) throws AutopujcovnaException {
        return null;
    }

    // odebere pobočku z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    public IPobocka odeberPobocku(Pozice pozice) throws AutopujcovnaException {
        return null;
    }

    // vloží nové auto do seznamu aktuální pobocky na příslušnou pozici
    public void vlozAuto(Auto auto, Pozice pozice) throws AutopujcovnaException {

    }

    // zpřístupní auto z požadované pozice aktuální pobočky (první, poslední, předchůdce, následník, aktuální)
    public Auto zpristupniAuto(Pozice pozice) throws AutopujcovnaException {
        return null;
    }

    // odebere auto z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    public Auto odeberAuto(Pozice pozice) throws AutopujcovnaException {
        return null;
    }

    // odebere auto z požadované pozice aktuální pobočky a vloží ho do seznamu výpůjček (první, poslední, následník, předchůdce, aktuální)
    public Auto vypujcAuto(Pozice pozice) throws AutopujdcovnaException {
        return null;
    }

    // odebere auto z požadované pozice výpůjček a vloží ho do seznamu aktuální pobočky (první, poslední, předchůdce, následník, aktuální)
    public Auto vratAuto(Pozice pozice) throws AutopujcovnaException {
        return null;
    }

    // zpřístupní auto z požadované pozice ze seznamu vypůjčených aut (první, poslední, předchůdce, následník, aktuální)
    public Auto zpristupniVypujceneAuto(Pozice pozice) throws AutopujcovnaException {
        return null;
    }

    // vrací požadovaný iterátor poboček/automobilů/vypůjčených automobilů
    public Iterator iterator(IteratorTyp typ) {
        return null;
    }

    // zruší všechna auta v aktuální pobočce
    public void zrusPobocku() throws AutopujcovnaException {
    }

    // zruší všechny pobočky
    public void zrus() {

    }

    public String getNazev() {
        return nazev;
    }

    @Override
    public String toString() {
        return nazev;
    }
}