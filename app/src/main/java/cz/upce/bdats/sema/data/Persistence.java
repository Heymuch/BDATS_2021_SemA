package cz.upce.bdats.sema.data;

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

public class Persistence {
    public static class Automobil {
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
}