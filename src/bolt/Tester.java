package bolt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Set;

import bolt.Bolt.BoltBejegyzes;
import bolt.aruk.Elelmiszer;
import bolt.aruk.Sajt;
import bolt.aruk.Szappan;
import bolt.aruk.Tej;
import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;

public class Tester {
	public static void main(String[] args) throws NemLetezoAruKivetel, TulSokLevonasKivetel, ParseException {
		Tests tests = new Tester().new Tests();
		tests.addAru();
		// tests.vaneAru();
		// tests.printAll();
		// tests.torolAru((long) 23456);
		tests.vasarol((long) 23456, 1);
		// tests.feltoltArut((long) 23456, 3);
		// tests.printAll();
	}

	public class Tests extends BoltFactory {
		SimpleDateFormat sdf;
		Bolt boltCC;
		Hashtable<Long, BoltBejegyzes> pult;
		Set<Long> keys;

		public Tests() {
			this.boltCC = new Bolt("CC", "Miskolc", "David");
			this.pult = boltCC.getPult();
			this.keys = pult.keySet();
			this.sdf = new SimpleDateFormat("yyyy/MM/dd");
		}

		public void addAru() throws ParseException {
			boltCC.feltoltUjAruval(ujTartosTej(12345, 2, "Mizo", sdf.parse("2017/05/14"), 1.0), 5, 200);
			boltCC.feltoltUjAruval(ujFeltartosTej(23456, 2, "Mizo", sdf.parse("2017/04/01"), 1.0), 2, 150);
			boltCC.feltoltUjAruval(ujFelzsirosFeltartosTej(34567, 1, "Mizo", sdf.parse("2017/03/25")), 6, 250);
			boltCC.feltoltUjAruval(ujFelzsirosLiteresFeltartosTej(45678, "Mizo", sdf.parse("2017/02/14")), 1, 300);
			boltCC.feltoltUjAruval(ujFelzsirosLiteresTartosTej(56789, "Mizo", sdf.parse("2017/03/01")), 7, 200);
			boltCC.feltoltUjAruval(ujFelzsirosTartosTej(13456, 2, "Mizo", sdf.parse("2017/02/02")), 3, 210);
			boltCC.feltoltUjAruval(ujZsirosFeltartosTej(24567, 1, "Mizo", sdf.parse("2017/02/02")), 8, 220);
			boltCC.feltoltUjAruval(ujZsirosLiteresFeltartosTej(46789, "Mizo", sdf.parse("2017/03/05")), 9, 230);
			boltCC.feltoltUjAruval(ujZsirosLiteresTartosTej(57891, "Mizo", sdf.parse("2017/03/02")), 10, 240);
			boltCC.feltoltUjAruval(ujZsirosTartosTej(68912, 1, "Mizo", sdf.parse("2017/04/27")), 4, 260);
			boltCC.feltoltUjAruval(ujSajt(98765, 1.5, "Tolle", sdf.parse("2017/02/20"), 1.0), 2, 500);
			boltCC.feltoltUjAruval(ujSajt(86543, 1.0, "Tolle", sdf.parse("2017/12/13"), 1.5), 3, 400);
			boltCC.feltoltUjAruval(ujSzappan(87654, "Fa", 'B'), 3, 300);
			boltCC.feltoltUjAruval(ujAMosohatasuSzappan(76543, "Fa"), 1, 200);
			System.out.println("Feltöltés kész!");
		}

		public void vaneAru() {
			System.out.println("Tej " + boltCC.vanMegTej());
			System.out.println("Sajt " + boltCC.vanMegSajt());
			System.out.println("Tej.class " + boltCC.vanMegAdottAru(Tej.class));
			System.out.println("Sajt.class " + boltCC.vanMegAdottAru(Sajt.class));
			System.out.println("Szappan.class " + boltCC.vanMegAdottAru(Szappan.class));
		}

		public void printAll() {
			for (Long key : keys) {
				System.out.println(pult.get(key).getAru().getClass());
				System.out.println(pult.get(key).getAru().toString());
				System.out.println("Mennyiség: " + pult.get(key).getMennyiseg());
				System.out.println("Ár: " + pult.get(key).getAr());
				;
				if (Elelmiszer.class.isAssignableFrom(pult.get(key).getAru().getClass())) {
					System.out.println("Jó még?: " + ((Elelmiszer) (pult.get(key).getAru())).joMeg());
				}
			}
		}

		public void torolAru(Long vonalKod) {
			boltCC.torolArut(vonalKod);
			if (!boltCC.vanMegTej()) {
				System.out.println("Tej törölve");
			} else if (!boltCC.vanMegSajt()) {
				System.out.println("Sajt törölve");
			} else if (!boltCC.vanMegAdottAru(Szappan.class)) {
				System.out.println("Szappan törölve");
			}
		}

		public void vasarol(Long vonalKod, long mennyiseg) {
			boltCC.vasarolArut(vonalKod, mennyiseg);
		}

		public void feltoltArut(Long vonalKod, long mennyiseg) {
			boltCC.feltoltAruval(vonalKod, mennyiseg);
		}
	}

}
