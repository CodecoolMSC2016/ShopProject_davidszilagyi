package bolt;

import java.util.Date;

public class Tej {
	private long vonalKod;
	private final int LITER;
	private final int FELLITER;
	private final int POHAR;
	private final double ZSIROS;
	private final double FELZSIROS;
	private int urtartalom;
	private String gyarto;
	private Date szavatossagiIdo;
	private double zsirtartalom;
	private long ar;

	public Tej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom, long ar) {
		this.vonalKod = vonalKod;
		this.urtartalom = urtartalom;
		this.gyarto = gyarto;
		this.szavatossagiIdo = szavatossagiIdo;
		this.zsirtartalom = zsirtartalom;
		this.ar = ar;
	}

	public long getVonalKod() {
		return vonalKod;
	}

	public boolean joMeg() {
		return true;
	}

	public int getUrtartalom() {
		return urtartalom;
	}

	public String getGyarto() {
		return gyarto;
	}

	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	public long getAr() {
		return ar;
	}

	@Override
	public String toString() {
		return String.format("Gyártó: %s%nZsírtartalom: %.1f%nŰrtartalom: %d%n Szavatossági Idő: %tD%n Ár: %d%n",
				getGyarto(), getZsirtartalom(), getUrtartalom(), getSzavatossagiIdo(), getAr());
	}
}
