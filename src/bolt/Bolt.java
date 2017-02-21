package bolt;

import java.util.Hashtable;
import java.util.Iterator;

public class Bolt {
	private String nev;
	private String cim;
	private String tulajdonos;
	private Hashtable tejpult;

	public Bolt(String nev, String cim, String tulajdonos, Hashtable tejpult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.tejpult = tejpult;
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

	public boolean vanMegTej() {
		return tejpult.size() > 0;
	}

	public Tej vasarolTej(long vonalKod) {
		if (vanMegTej()) {
			Iterator tejpultIterator = tejpult.entrySet().iterator();
			while (tejpultIterator.hasNext()) {
				Tej temp = (Tej) tejpultIterator.next();
				if (temp.getVonalKod() == vonalKod) {
					tejpultIterator.remove();
					return temp;
				}
			}
		}
		System.out.println("Elfogyott a tej");
		return null;
	}

	public void feltoltTej(Tej m) {
		tejpult.put(m.getVonalKod(), m);
	}

	public class BoltBejegyzes {
		private Tej t;
		private int mennyiseg;
		private int ar;

		public BoltBejegyzes(Tej t, int mennyiseg, int ar) {
			this.t = t;
			this.mennyiseg = mennyiseg;
			this.ar = ar;
		}

		public Tej getT() {
			return t;
		}

		public void setT(Tej t) {
			this.t = t;
		}

		public int getMennyiseg() {
			return mennyiseg;
		}

		public void setMennyiseg(int mennyiseg) {
			this.mennyiseg = mennyiseg;
		}

		public void adMennyiseg(int mennyiseg) {
			this.mennyiseg += mennyiseg;
		}

		public void levonMennyiseg(int mennyiseg) {
			this.mennyiseg -= mennyiseg;
		}

		public int getAr() {
			return ar;
		}

		public void setAr(int ar) {
			this.ar = ar;
		}
	}
}
