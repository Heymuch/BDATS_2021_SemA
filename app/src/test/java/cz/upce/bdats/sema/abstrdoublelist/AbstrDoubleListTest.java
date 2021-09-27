package cz.upce.bdats.sema.abstrdoublelist;

import org.junit.Test;
import static org.junit.Assert.*;

public class AbstrDoubleListTest {
    private static final Integer INT10 = new Integer(10);
    private static final Integer INT20 = new Integer(20);
    private static final Integer INT30 = new Integer(30);

    @Test(expected=AbstrDoubleList.ListException.class)
    public void zpristupniAktualniPrazdnySeznamTest() throws Exception {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>();
        l.zpristupniAktualni();
        fail();
    }

    @Test(expected=AbstrDoubleList.ListException.class)
    public void zpristupniPrvniPrazdnySeznamTest() throws Exception {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>();
        l.zpristupniPrvni();
        fail();
    }

    @Test
    public void zpristupniPrvniPlnySeznamTest() throws Exception {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>(INT10, INT20, INT30);
        assertEquals(10, l.zpristupniPrvni().intValue(), 0);
        assertEquals(10, l.zpristupniAktualni().intValue(), 0);
    }

    @Test(expected=AbstrDoubleList.ListException.class)
    public void zpristupniPosledniPrazdnySeznamTest() throws Exception {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>();
        l.zpristupniPosledni();
        fail();
    }

    @Test
    public void zpristupniPosledniPlnySeznamTest() throws Exception {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>(INT10, INT20, INT30);
        assertEquals(30, l.zpristupniPosledni().intValue(), 0);
        assertEquals(30, l.zpristupniAktualni().intValue(), 0);
    }

    @Test
    public void vlozPrvniPrazdnySeznamTest() throws Exception {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>();
        l.vlozPrvni(new Integer(10));
        assertEquals(10, l.zpristupniPrvni(), 0);
    }

    @Test
    public void prazdnyTest() {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>();
        assertTrue(l.jePrazdny());
    }

    @Test
    public void neniPrazdnyTest() {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>();
        l.vlozPrvni(new Integer(10));
        assertFalse(l.jePrazdny());
    }

    @Test
    public void prazdnyPoZruseniTest() {
        IAbstrDoubleList<Integer> l = new AbstrDoubleList<>();
        l.vlozPrvni(new Integer(10));
        l.zrus();
        assertTrue(l.jePrazdny());
    }
}