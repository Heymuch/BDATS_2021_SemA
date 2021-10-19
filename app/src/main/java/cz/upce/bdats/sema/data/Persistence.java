package cz.upce.bdats.sema.data;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

import cz.upce.bdats.sema.autopujcovna.Auto;
import cz.upce.bdats.sema.autopujcovna.OsobniAuto;
import cz.upce.bdats.sema.autopujcovna.UzitkoveAuto;
import cz.upce.bdats.sema.autopujcovna.Typ;
import cz.upce.bdats.sema.autopujcovna.Barva;
import cz.upce.bdats.sema.autopujcovna.IPobocka;
import cz.upce.bdats.sema.autopujcovna.Pobocka;
import cz.upce.bdats.sema.autopujcovna.Pozice;
import cz.upce.bdats.sema.autopujcovna.IAutopujcovna;
import cz.upce.bdats.sema.autopujcovna.IteratorTyp;

public class Persistence {
    public static class Automobily {
        public static String toCSV(Auto a) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s;%s;%.2f;%d", a.getTyp().name(), a.getSPZ(), a.getStavKm(), a.getPocetVypujceni()));
            switch (a.getTyp()) {
                case OSOBNI:
                    OsobniAuto o = (OsobniAuto) a;
                    sb.append(String.format(";%s", o.getBarva().name()));
                    break;
                case UZITKOVY:
                    UzitkoveAuto u = (UzitkoveAuto) a;
                    sb.append(String.format(";%.2f", u.getNosnost()));
                    break;
            }
            return sb.toString();
        }

        public static Auto fromCSV(String s) {
            String[] frags = s.split(";");
            Typ typ = Typ.valueOf(frags[0]);
            String spz = frags[1];
            float stavKm = Float.valueOf(frags[2]);
            int pocetVypujceni = Integer.valueOf(frags[3]);

            switch (typ) {
                case OSOBNI: return new OsobniAuto(spz, stavKm, pocetVypujceni, Barva.valueOf(frags[4]));
                case UZITKOVY: return new UzitkoveAuto(spz, stavKm, pocetVypujceni, Float.valueOf(frags[4]));
                default: return null;
            }
        }

        public static byte[] toBin(Auto a) throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(a);
            oos.flush();
            byte[] b = baos.toByteArray();
            oos.close();
            return b;
        }

        public static Auto fromBin(byte[] b) throws IOException, ClassNotFoundException {
            ByteArrayInputStream bais = new ByteArrayInputStream(b);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Auto a = (Auto) ois.readObject();
            ois.close();
            return a;
        }
    }

    public static class Pobocky {
        public static String[] toCSV(IPobocka p) {
            List<String> l = new ArrayList<>();
            l.add(String.format("%s;%d", p.getNazev(), p.pocetAut()));
            Iterator<Auto> i = p.iterator();
            while (i.hasNext())
                l.add(Persistence.Automobily.toCSV(i.next()));
            return l.toArray(new String[l.size()]);
        }

        public static IPobocka fromCSV(String[] csv) throws Exception {
            String[] frags = csv[0].split(";");
            String nazev = frags[0];

            IPobocka p = new Pobocka(nazev);
            for (int i = 1; i < csv.length; i++)
                p.vlozAuto(Persistence.Automobily.fromCSV(csv[i]), Pozice.POSLEDNI);
            return p;
        }
    }

    public static class Autopujcovny {
        public static String[] toCSV(IAutopujcovna a) throws Exception {
            List<String> l = new ArrayList<>();
            l.add(String.format("%s;%d;%d", a.getNazev(), a.pocetVypujcenychAut(), a.pocetPobocek()));
            Iterator<Auto> vypujcene = a.iterator(IteratorTyp.VYPUJCENE_AUTOMOBILY);
            while (vypujcene.hasNext())
                l.add(Persistence.Automobily.toCSV(vypujcene.next()));

            Iterator<IPobocka> pobocky = a.iterator(IteratorTyp.POBOCKY);
            while (pobocky.hasNext())
                l.addAll(Arrays.asList(Persistence.Pobocky.toCSV(pobocky.next())));

            return l.toArray(new String[l.size()]);
        }

        public static IAutopujcovna fromCSV(String[] csv) {
            return null;
        }
    }
}