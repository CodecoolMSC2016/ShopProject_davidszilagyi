package bolt;

import java.util.Hashtable;

import bolt.aruk.Sajt;
import bolt.aruk.Tej;
import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;

public class Bolt {
	private String nev;
	private String cim;
	private String tulajdonos;
	private Hashtable<Class<? extends Aru>, BoltBejegyzes> pult;

	public Bolt(String nev, String cim, String tulajdonos, Hashtable<Class<? extends Aru>, BoltBejegyzes> pult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.pult = pult;
	}

	public Bolt(String nev, String cim, String tulajdonos) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.pult = new Hashtable<Class<? extends Aru>, BoltBejegyzes>();
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

	public Hashtable<Class<? extends Aru>, BoltBejegyzes> getPult() {
		return pult;
	}

	public boolean vanMegAdottAru(Class<?> c) throws NemLetezoAruKivetel {
		try {
			for (Class<? extends Aru> key : pult.keySet()) {
				if (c.isAssignableFrom(key)) {
					return true;
				}
			}
			throw new NemLetezoAruKivetel("Nem létező áru");
		} catch (Exception NemLetezoAruKivetel) {
			NemLetezoAruKivetel.getMessage();
			return false;
		}

	}

	public boolean vanMegTej() {
		for (Class<? extends Aru> key : pult.keySet()) {
			if (Tej.class.isAssignableFrom(key)) {
				return (pult.get(key).getMennyiseg()) > 0;
			}
		}
		return false;
	}

	public boolean vanMegSajt() {
		for (Class<? extends Aru> key : pult.keySet()) {
			if (Sajt.class.isAssignableFrom(key)) {
				return (pult.get(key).getMennyiseg()) > 0;
			}
		}
		return false;
	}

	public void feltoltAruval(long vonalKod, long mennyiseg) {
		for (Class<? extends Aru> key : pult.keySet()) {
			BoltBejegyzes boltBejegyzes = pult.get(key);
			if ((boltBejegyzes.getAru().getVonalKod()) == vonalKod) {
				boltBejegyzes.setMennyiseg(mennyiseg);
			}
		}
	}

	public void feltoltUjElelmiszerrel(Aru a, long mennyiseg, long ar) {
		BoltBejegyzes boltBejegyzes = new BoltBejegyzes(a, mennyiseg, ar);
		pult.put(a.getClass(), boltBejegyzes);
	}

	public void torolArut(long vonalKod) {
		for (Class<? extends Aru> key : pult.keySet()) {
			BoltBejegyzes boltBejegyzes = pult.get(key);
			if ((boltBejegyzes.getAru().getVonalKod()) == vonalKod) {
				pult.remove(key);
			}
		}
	}

	public void vasarolElelmiszert(long vonalKod, long mennyiseg) throws TulSokLevonasKivetel {
		try {
			for (Class<? extends Aru> key : pult.keySet()) {
				BoltBejegyzes boltBejegyzes = pult.get(key);
				if ((boltBejegyzes.getAru().getVonalKod()) == vonalKod) {
					if (boltBejegyzes.getMennyiseg() < mennyiseg) {
						throw new TulSokLevonasKivetel("Nincs ennyi mennyiség!");
					} else {
						boltBejegyzes.levonMennyiseg(mennyiseg);
					}
				}
			}
		} catch (Exception TulSokLevonasKivetel) {
			TulSokLevonasKivetel.getMessage();
		}
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
