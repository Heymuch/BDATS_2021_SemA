package cz.upce.bdats.sema.data;

import java.util.Random;

import cz.upce.bdats.sema.autopujcovna.Auto;

public class Generator {
    // Konstruktor
    private static final Random RNG = new Random();

    // Pomocné metody
    public static String genSPZ() {
        return String.format("%d%c%d %04d", RNG.nextInt(10), 'A' + RNG.nextInt('Z' - 'A' + 1), RNG.nextInt(10), RNG.nextInt(1000));
    }

    public static Auto genAuto() {
    }
}