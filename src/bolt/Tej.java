package bolt;

import java.util.Date;

public class Tej {
	public final int LITER;
	public final int FELLITER;
	public final int POHAR;
	public final double ZSIROS;
	public final double FELZSIROS;
	protected long vonalKod;
	protected int urtartalom;
	protected String gyarto;
	protected Date szavatossagiIdo;
	protected double zsirtartalom;
	protected long ar;

	public Tej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		this.vonalKod = vonalKod;
		this.urtartalom = urtartalom;
		this.gyarto = gyarto;
		this.szavatossagiIdo = szavatossagiIdo;
		this.zsirtartalom = zsirtartalom;
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
