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
				if (temp.getVonalKod() == vonalkod) {
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
}
