package cz.upce.bdats.sema.data;

import org.junit.Test;
import static org.junit.Assert.*;

import cz.upce.bdats.sema.autopujcovna.Auto;
import cz.upce.bdats.sema.autopujcovna.OsobniAuto;
import cz.upce.bdats.sema.autopujcovna.UzitkoveAuto;
import cz.upce.bdats.sema.autopujcovna.Barva;

public class PerzistenceTest {
    private static final Auto A1 = new OsobniAuto("1S1 1111", 1.0f, 1, Barva.CERVENA);
    private static final Auto A2 = new OsobniAuto("2S2 2222", 2.0f, 2, Barva.CERNA);
    private static final Auto A3 = new UzitkoveAuto("3S3 3333", 3.0f, 3, 10.0f);
    private static final Auto A4 = new UzitkoveAuto("4S4 4444", 4.0f, 4, 20.0f);

    @Test
    public void autoToCSVTest() throws Exception {
        String csv1 = Persistence.Automobil.toCSV(A1);
        String csv2 = Persistence.Automobil.toCSV(A2);
        String csv3 = Persistence.Automobil.toCSV(A3);
        String csv4 = Persistence.Automobil.toCSV(A4);

        System.out.println(csv1);
        System.out.println(csv2);
        System.out.println(csv3);
        System.out.println(csv4);
    }
}