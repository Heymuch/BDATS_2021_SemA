package cz.upce.bdats.sema.autopujcovna;

import java.util.Iterator;

public interface IAutopujcovna {
    // vloží novou pobočku do seznamu na příslušnou pozici (první, poslední, předchůdce, následník)
    void vlozPobocku(IPobocka pobocka, EnumPozice pozice);

    // zpřístupní pobočku z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    IPobocka zpristupniPobocku(EnumPozice pozice);

    // odebere pobočku z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    IPobocka odeberPobocku(EnumPozice pozice);

    // vloží nové auto do seznamu aktuální pobocky na příslušnou pozici
    void vlozAuto(Auto auto, EnumPozice pozice);

    // zpřístupní auto z požadované pozice aktuální pobočky (první, poslední, předchůdce, následník, aktuální)
    Auto zpristupniAuto(EnumPozice pozice);

    // odebere auto z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    Auto odeberAuto(EnumPozice pozice);

    // odebere auto z požadované pozice aktuální pobočky a vloží ho do seznamu výpůjček (první, poslední, následník, předchůdce, aktuální)
    Auto vypujcAuto(EnumPozice pozice);

    // odebere auto z požadované pozice výpůjček a vloží ho do seznamu aktuální pobočky (první, poslední, předchůdce, následník, aktuální)
    Auto vratAuto(EnumPozice pozice);

    // zpřístupní auto z požadované pozice ze seznamu vypůjčených aut (první, poslední, předchůdce, následník, aktuální)
    Auto zpristupniVypujceneAuto(EnumPozice pozice);

    // vrací požadovaný iterátor poboček/automobilů/vypůjčených automobilů
    Iterator iterator(IteratorTyp typ);

    // zruší všechna auta v aktuální pobočce
    void zrusPobocku();

    // zruší všechny pobočky
    void zrus();
}