package bolt;

import java.util.Vector;

public class Bolt {
	private String nev;
	private String cim;
	private String tulajdonos;
	private Vector tejpult;

	public Bolt(String nev, String cim, String tulajdonos, Vector tejpult) {
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
		return true;
	}

	public Tej vasarolTej(Tej m) {
		return null;
	}

	public void feltoltTej(Tej m) {
	}
}
