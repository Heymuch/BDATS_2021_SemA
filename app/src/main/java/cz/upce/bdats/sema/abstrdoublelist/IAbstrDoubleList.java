package cz.upce.bdats.sema.abstrdoublelist;

public interface IAbstrDoubleList<T> implements Iterable {
    // zrušení celého seznamu
    void zrus();
    // test naplněnosti seznamu
    boolean jePrazdny();

    // vložení prvku do seznamu na první místo
    void vlozPrvni(T data);
    // vložení prvku do seznamu na poslední místo
    void vlozPosledni(T data);
    // vložení prvku do seznamu jakožto následníka aktuálního prvku
    void vlozNaslednika(T data);
    // vložení prvku do seznamu jakožto předchůdce aktuálního prvku
    void vlozPredchudce(T data);

    // Operace zpřístupnění mění pozici aktuálního prvku
    // zpřístupnení aktuálního prvku seznamu
    T zpristupniAktualni();
    // zpristupneni prvního prvku seznamu
    T zpristupniPrvni();
    // zpřístupnění posledního prvku prvku seznamu
    T zpristupniPosledni();
    // zpřístupnění následníha aktuálního prvku
    T zpristupniNaslednika();
    // zpřístupnění předchůdce aktuálního prvku
    T zpristupniPredchudce();

    // odebrání aktuálního prvku ze seznamu, aktuální prvek je nastaven na první prvek seznamu
    T odeberAktualni();
    // odebrání prvního prvku ze seznamu
    T odeberPrvni();
    // odebrání posledního prvku ze seznamu
    T odeberPosledno();
    // odebrání následníka aktuálního prvku ze seznamu
    T odeberNaslednika();
    // odebrani předchůdce aktuálního prvku ze seznamu
    T odeberPredchudce();

    // vytvoření iterátoru
    Iterator<T> iterator();
}