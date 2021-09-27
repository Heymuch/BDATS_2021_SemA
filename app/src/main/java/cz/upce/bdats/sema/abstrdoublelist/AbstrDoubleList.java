package cz.upce.bdats.sema.abstrdoublelist;

import java.util.Objects;
import java.util.Iterator;

public class AbstrDoubleList<T> implements IAbstrDoubleList<T> {
    // Vnitřní třídy
    private class Prvek {
        // Atributy
        T data;
        Prvek predchozi;
        Prvek nasledujici;

        // Konstruktory
        Prvek(T data) {
            this(data, null, null);
        }

        Prvek(T data, Prvek predchozi, Prvek nasledujici) {
            this.data = data;
            this.predchozi = predchozi;
            this.nasledujici = nasledujici;
        }
    }

    public static class ListException extends Exception {
        // Konstanty
        private static final ListException NENI_AKTUALNI = new ListException("Není nastaven aktuální prvek!");
        private static final ListException NEIMPL = new ListException("Není implementováno!");
        private static final ListException PRAZDNY = new ListException("Seznam je prázdný!");

        // Konstruktor
        private ListException(String zprava) {
            super(zprava);
        }
    }

    // Atributy
    Prvek aktualni;
    Prvek prvni;
    Prvek posledni;

    // Konstruktory
    public AbstrDoubleList() {
    }

    public AbstrDoubleList(T... data) {
        for (T d : data)
            vlozPosledni(d);
    }

    // Metody
    @Override
    public void zrus() {
        aktualni = null;
        prvni = null;
        posledni = null;
    }

    @Override
    public boolean jePrazdny() {
        return Objects.isNull(prvni);
    }

    @Override
    public void vlozPrvni(T data) {
        Prvek p = new Prvek(data, null, prvni);

        if (jePrazdny()) posledni = p;
        prvni = p;
    }

    @Override
    public void vlozPosledni(T data) {
        Prvek p = new Prvek(data, posledni, null);

        if (jePrazdny()) prvni = p;
        posledni = p;
    }

    @Override
    public void vlozNaslednika(T data) throws Exception {
        if (Objects.isNull(aktualni)) throw ListException.NENI_AKTUALNI; // pokud není nastaven aktuální prvek

        if (aktualni == posledni) { // pokud je aktuální poslední
            vlozPosledni(data);
            return;
        }

        Prvek p = new Prvek(data, aktualni, aktualni.nasledujici);
        aktualni.nasledujici = p;
        p.nasledujici.predchozi = p;
    }

    @Override
    public void vlozPredchudce(T data) throws Exception {
        // TODO
        throw ListException.NEIMPL;
    }

    @Override
    public T zpristupniAktualni() throws Exception {
        if (Objects.isNull(aktualni)) throw ListException.NENI_AKTUALNI; // pokud není nastaven aktuální

        return aktualni.data;
    }

    @Override
    public T zpristupniPrvni() throws Exception {
        if (jePrazdny()) throw ListException.PRAZDNY;
        aktualni = prvni;
        return aktualni.data;
    }

    @Override
    public T zpristupniPosledni() throws Exception {
        if (jePrazdny()) throw ListException.PRAZDNY;
        aktualni = posledni;
        return aktualni.data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}