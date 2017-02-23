package bolt;

import java.util.Hashtable;

import bolt.aruk.Sajt;
import bolt.aruk.Tej;
import bolt.kivetel.LetezoVonalKodKivetel;
import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;

public class Bolt {
	private String nev;
	private String cim;
	private String tulajdonos;
	private Hashtable<Long, BoltBejegyzes> pult;

	public Bolt(String nev, String cim, String tulajdonos, Hashtable<Long, BoltBejegyzes> pult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.pult = pult;
	}

	public Bolt(String nev, String cim, String tulajdonos) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.pult = new Hashtable<Long, BoltBejegyzes>();
	}

	public String getNev() {
		return nev;
	}

	public String getCim() {
		return cim;
	}

	public String getTulajdonos() {
		return tulajdonos;
	}

	public Hashtable<Long, BoltBejegyzes> getPult() {
		return pult;
	}

	public boolean vanMegAdottAru(Class<?> c) {
		try {
			for (Long key : pult.keySet()) {
				if (c.isAssignableFrom(pult.get(key).getAru().getClass())) {
					return true;
				}
			}
			throw new NemLetezoAruKivetel(String.format("Nem létező áru: ", c.getSimpleName()));
		} catch (NemLetezoAruKivetel nlak) {
			System.out.println(nlak.getMessage());
			return false;
		}
	}

	public boolean vanMegTej() {
		for (Long key : pult.keySet()) {
			if (Tej.class.isAssignableFrom(pult.get(key).getAru().getClass())) {
				return (pult.get(key).getMennyiseg()) > 0;
			}
		}
		return false;
	}

	public boolean vanMegSajt() {
		for (Long key : pult.keySet()) {
			if (Sajt.class.isAssignableFrom(pult.get(key).getAru().getClass())) {
				return (pult.get(key).getMennyiseg()) > 0;
			}
		}
		return false;
	}

	public void feltoltAruval(Long vonalKod, long mennyiseg) {
		try {
			if (letezoVonalKod(vonalKod)) {
				pult.get(vonalKod).adMennyiseg(mennyiseg);
			} else {
				throw new NemLetezoAruKivetel(String.format("Nincs ilyen vonalkóddal ellátott termék: %d", vonalKod));
			}
		} catch (NemLetezoAruKivetel nlak) {
			System.out.println(nlak.getMessage());
		}

	}

	public void feltoltUjAruval(Aru a, long mennyiseg, long ar) {
		try {
			if (!letezoVonalKod(a.getVonalKod())) {
				BoltBejegyzes boltBejegyzes = new BoltBejegyzes(a, mennyiseg, ar);
				pult.put(boltBejegyzes.getAru().getVonalKod(), boltBejegyzes);
			} else {
				throw new LetezoVonalKodKivetel(String.format("Már van ilyen vonalkód: ", a.getVonalKod()));
			}
		} catch (LetezoVonalKodKivetel lvkk) {
			System.out.println(lvkk.getMessage());
		}
	}

	public void torolArut(Long vonalKod) {
		try {
			if (letezoVonalKod(vonalKod)) {
				pult.remove(vonalKod);
			} else {
				throw new NemLetezoAruKivetel(String.format("Nincs ilyen vonalkóddal ellátott termék: %d", vonalKod));
			}
		} catch (NemLetezoAruKivetel nlak) {
			System.out.println(nlak.getMessage());
		}
	}

	public void vasarolArut(Long vonalKod, long mennyiseg) {
		try {
			if (letezoVonalKod(vonalKod)) {
				if (pult.get(vonalKod).getMennyiseg() < mennyiseg) {
					throw new TulSokLevonasKivetel(
							String.format("Nincs ennyi mennyiség: %s (Vonalkód: %d - Készleten: %s)", mennyiseg,
									vonalKod, pult.get(vonalKod).getMennyiseg()));
				} else {
					pult.get(vonalKod).levonMennyiseg(mennyiseg);
				}
			} else {
				throw new NemLetezoAruKivetel(String.format("Nincs ilyen vonalkóddal ellátott termék: %d", vonalKod));
			}
		} catch (TulSokLevonasKivetel tslk) {
			System.out.println(tslk.getMessage());
		} catch (NemLetezoAruKivetel nlak) {
			System.out.println(nlak.getMessage());
		}
	}

	public boolean letezoVonalKod(Long vonalKod) {
		for (Long key : pult.keySet()) {
			if ((pult.get(key).getAru().getVonalKod()).equals(vonalKod)) {
				return true;
			}
		}
		return false;
	}

	public class BoltBejegyzes {
		private Aru a;
		private long mennyiseg;
		private long ar;

		public BoltBejegyzes(Aru a, long mennyiseg, long ar) {
			this.a = a;
			this.mennyiseg = mennyiseg;
			this.ar = ar;
		}

		public Aru getAru() {
			return a;
		}

		public void setAru(Aru a) {
			this.a = a;
		}

		public long getMennyiseg() {
			return mennyiseg;
		}

		public void setMennyiseg(long mennyiseg) {
			this.mennyiseg = mennyiseg;
		}

		public void adMennyiseg(long mennyiseg) {
			this.mennyiseg += mennyiseg;
		}

		public void levonMennyiseg(long mennyiseg) {
			this.mennyiseg -= mennyiseg;
		}

		public long getAr() {
			return ar;
		}

		public void setAr(long ar) {
			this.ar = ar;
		}
	}
}
