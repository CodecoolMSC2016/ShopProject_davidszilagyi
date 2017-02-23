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
			throw new NemLetezoAruKivetel("Nem létező áru");
		} catch (Exception NemLetezoAruKivetel) {
			System.out.println(NemLetezoAruKivetel.getMessage());
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
		for (Long key : pult.keySet()) {
			if ((pult.get(key).getAru().getVonalKod()).equals(vonalKod)) {
				pult.get(key).adMennyiseg(mennyiseg);
			}
		}
	}

	public void feltoltUjAruval(Aru a, long mennyiseg, long ar) {
		try {
			if (!letezoVonalKod(a.getVonalKod())) {
				BoltBejegyzes boltBejegyzes = new BoltBejegyzes(a, mennyiseg, ar);
				pult.put(boltBejegyzes.getAru().getVonalKod(), boltBejegyzes);
			} else {
				throw new LetezoVonalKodKivetel("Már van ilyen Vonalkód: " + a.getVonalKod());
			}
		} catch (Exception LetezoVonalKodKivetel) {
			System.out.println(LetezoVonalKodKivetel.getMessage());
		}
	}

	public void torolArut(Long vonalKod) {
		for (Long key : pult.keySet()) {
			if ((pult.get(key).getAru().getVonalKod()).equals(vonalKod)) {
				pult.remove(key);
			}
		}
	}

	public void vasarolArut(Long vonalKod, long mennyiseg) {
		try {
			for (Long key : pult.keySet()) {
				if ((pult.get(key).getAru().getVonalKod()).equals(vonalKod)) {
					if (pult.get(key).getMennyiseg() < mennyiseg) {
						throw new TulSokLevonasKivetel("Nincs ennyi mennyiség!");
					} else {
						pult.get(key).levonMennyiseg(mennyiseg);
					}
				}
			}
		} catch (Exception TulSokLevonasKivetel) {
			System.out.println(TulSokLevonasKivetel.getMessage());
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
