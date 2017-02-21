package bolt;

public class Bolt {
	private String nev;
	private String cim;
	private String tulajdonos;
	private Tej[] tejpult;
	private int flag;

	public Bolt(String nev, String cim, String tulajdonos, Tej[] tejpult) {
		this.nev = nev;
		this.cim = cim;
		this.tulajdonos = tulajdonos;
		this.tejpult = tejpult;
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
		return tejpult.length > 0;
	}

	public Tej vasarolTej(Tej m) {
		if (vanMegTej()) {
			Tej tej = tejpult[0];
			tejpult = new Tej[tejpult.length - 1];
			return tej;
		}
		System.out.println("Elfogyott a tej");
		return null;
	}
}
