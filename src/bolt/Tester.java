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

public class Tester extends BoltFactory {
	SimpleDateFormat sdf;
	Bolt boltCC;
	Hashtable<Class<? extends Aru>, BoltBejegyzes> pult;
	Set<?> keys;

	public Tester() {
		this.boltCC = new Bolt("CC", "Miskolc", "David");
		this.pult = boltCC.getPult();
		this.keys = pult.keySet();
		this.sdf = new SimpleDateFormat("yyyy/MM/dd");
	}

	public void addAru() throws ParseException {
		Tej tej1 = ujTartosTej(12345, 2, "Mizo", sdf.parse("2017/05/14"), 1.0);
		Tej tej2 = ujFeltartosTej(23456, 2, "Mizo", sdf.parse("2017/04/01"), 1.0);
		Tej tej3 = ujFelzsirosFeltartosTej(34567, 1, "Mizo", sdf.parse("2017/03/25"));
		Tej tej4 = ujFelzsirosLiteresFeltartosTej(45678, "Mizo", sdf.parse("2017/02/14"));
		Tej tej5 = ujFelzsirosLiteresTartosTej(56789, "Mizo", sdf.parse("2017/03/01"));
		Tej tej6 = ujFelzsirosTartosTej(13456, 2, "Mizo", sdf.parse("2017/02/02"));
		Tej tej7 = ujZsirosFeltartosTej(24567, 1, "Mizo", sdf.parse("2017/02/02"));
		Tej tej8 = ujZsirosLiteresFeltartosTej(46789, "Mizo", sdf.parse("2017/03/05"));
		Tej tej9 = ujZsirosLiteresTartosTej(57891, "Mizo", sdf.parse("2017/03/02"));
		Tej tej10 = ujZsirosTartosTej(68912, 1, "Mizo", sdf.parse("2017/04/27"));
		Sajt sajt1 = ujSajt(98765, 1.5, "Tolle", sdf.parse("2017/02/20"), 1.0);
		Sajt sajt2 = ujSajt(86543, 1.0, "Tolle", sdf.parse("2017/12/13"), 1.5);
		Szappan szappan1 = ujSzappan(87654, "Fa", 'B');
		Szappan szappan2 = ujAMosohatasuSzappan(76543, "Fa");
		// boltCC.feltoltUjAruval(tej1, 5, 200);
		boltCC.feltoltUjAruval(tej2, 2, 150);
		// boltCC.feltoltUjAruval(tej3, 6, 250);
		// boltCC.feltoltUjAruval(tej4, 1, 300);
		// boltCC.feltoltUjAruval(tej5, 7, 200);
		// boltCC.feltoltUjAruval(tej6, 3, 210);
		// boltCC.feltoltUjAruval(tej7, 8, 220);
		// boltCC.feltoltUjAruval(tej8, 9, 230);
		// boltCC.feltoltUjAruval(tej9, 10, 240);
		// boltCC.feltoltUjAruval(tej10, 4, 260);
		// boltCC.feltoltUjAruval(sajt1, 2, 500);
		boltCC.feltoltUjAruval(sajt2, 3, 400);
		boltCC.feltoltUjAruval(szappan1, 3, 300);
		// boltCC.feltoltUjAruval(szappan2, 1, 200);
		System.out.println("Feltöltés kész!");
	}

	public void vaneAru() throws NemLetezoAruKivetel {
		System.out.println("Tej " + boltCC.vanMegTej());
		System.out.println("Sajt " + boltCC.vanMegSajt());
		System.out.println("Tej.class " + boltCC.vanMegAdottAru(Tej.class));
		System.out.println("Sajt.class " + boltCC.vanMegAdottAru(Sajt.class));
		System.out.println("Szappan.class " + boltCC.vanMegAdottAru(Szappan.class));
	}

	public void printAll() {
		for (Object key : keys) {
			System.out.println(key);
			System.out.println(pult.get(key).getAru().toString());
			System.out.println("Mennyiség: " + pult.get(key).getMennyiseg());
			System.out.println("Ár: " + pult.get(key).getAr());
			;
			if (Elelmiszer.class.isAssignableFrom((Class<? extends Aru>) key)) {
				System.out.println("Jó még?: " + ((Elelmiszer) (pult.get(key).getAru())).joMeg());
			}
		}
	}

	public void torolAru(long vonalKod) throws NemLetezoAruKivetel {
		boltCC.torolArut(vonalKod);
		if (!boltCC.vanMegTej()) {
			System.out.println("Tej törölve");
		} else if (!boltCC.vanMegSajt()) {
			System.out.println("Sajt törölve");
		} else if (!boltCC.vanMegAdottAru(Szappan.class)) {
			System.out.println("Szappan törölve");
		}
	}

	public void vasarol(long vonalKod, long mennyiseg) {
		boltCC.vasarolArut(vonalKod, mennyiseg);
	}

	public void feltoltArut(long vonalKod, long mennyiseg) {
		boltCC.feltoltAruval(vonalKod, mennyiseg);
	}
}
