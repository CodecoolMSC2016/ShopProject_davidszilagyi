package bolt;

import java.util.Hashtable;

public class Bolt {
	private String nev;
	private String cim;
	private String tulajdonos;
	private Hashtable<Class<? extends Elelmiszer>, BoltBejegyzes> elelmiszerpult;

	public Bolt(String nev, String cim, String tulajdonos,
			Hashtable<Class<? extends Elelmiszer>, BoltBejegyzes> elelmiszerpult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.elelmiszerpult = elelmiszerpult;
	}

	public Bolt(String nev, String cim, String tulajdonos) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
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

	public boolean vanMegAdottAru(Class<?> c) {
		for (Class<? extends Elelmiszer> key : elelmiszerpult.keySet()) {
			if (c.isAssignableFrom(key)) {
				return true;
			}
		}
		return false;

	}

	public boolean vanMegTej() {
		for (Class<? extends Elelmiszer> key : elelmiszerpult.keySet()) {
			if (key.isInstance(Tej.class)) {
				return (elelmiszerpult.get(key).getMennyiseg()) > 0;
			}
		}
		return false;
	}

	public boolean vanMegSajt() {
		for (Class<? extends Elelmiszer> key : elelmiszerpult.keySet()) {
			if (key.isInstance(Sajt.class)) {
				return (elelmiszerpult.get(key).getMennyiseg()) > 0;
			}
		}
		return false;
	}

	public void feltoltElelmiszerrel(long vonalKod, long mennyiseg) {
		for (Class<? extends Elelmiszer> key : elelmiszerpult.keySet()) {
			BoltBejegyzes boltBejegyzes = elelmiszerpult.get(key);
			if ((boltBejegyzes.getElelmiszer().getVonalKod()) == vonalKod) {
				boltBejegyzes.setMennyiseg(mennyiseg);
			}
		}
	}

	public void feltoltUjElelmiszerrel(Elelmiszer e, long mennyiseg, long ar) {
		BoltBejegyzes boltBejegyzes = new BoltBejegyzes(e, mennyiseg, ar);
		elelmiszerpult.put(e.getClass(), boltBejegyzes);
	}

	public void torolElelmiszert(long vonalKod) {
		for (Class<? extends Elelmiszer> key : elelmiszerpult.keySet()) {
			BoltBejegyzes boltBejegyzes = elelmiszerpult.get(key);
			if ((boltBejegyzes.getElelmiszer().getVonalKod()) == vonalKod) {
				elelmiszerpult.remove(key);
			}
		}
	}

	public void vasarolElelmiszert(long vonalKod, long mennyiseg) {
		for (Class<? extends Elelmiszer> key : elelmiszerpult.keySet()) {
			BoltBejegyzes boltBejegyzes = elelmiszerpult.get(key);
			if ((boltBejegyzes.getElelmiszer().getVonalKod()) == vonalKod) {
				boltBejegyzes.levonMennyiseg(mennyiseg);
			}
		}
	}

	public class BoltBejegyzes {
		private Elelmiszer e;
		private long mennyiseg;
		private long ar;

		public BoltBejegyzes(Elelmiszer e, long mennyiseg, long ar) {
			this.e = e;
			this.mennyiseg = mennyiseg;
			this.ar = ar;
		}

		public Elelmiszer getElelmiszer() {
			return e;
		}

		public void setElelmiszer(Elelmiszer e) {
			this.e = e;
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
