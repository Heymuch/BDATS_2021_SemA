package cz.upce.bdats.sema.autopujcovna;

interface IPobocka {
    // vloží nové auto do seznamu na příslušnou pozici (první, poslední, předchůdce, následník)
    void vlozAuto(Auto auto, EnumPozice pozice);

    // zpřístupní auto z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    Auto zpristupniAuto(EnumPozice pozice);

    // odebere auto z požadované pozice (první, poslední, předchůdce, následník, aktuální)
    Auto odeberAuto(EnumPozice pozice);

    // vytvoří iterátor
    Iterator<Auto> iterator();

    // zruší všechna auta
    void zrus();
}