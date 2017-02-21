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

	public Tej(int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom, long ar) {
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
		return new Date().before(getSzavatossagiIdo());
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
		return String.format("Gyártó: %s%nŰrtartalom: %d%nZsírtartalom: %f%nSzavatossagi idő: %tD%nÁr: %d", getGyarto(),
				getUrtartalom(), getZsirtartalom(), getSzavatossagiIdo(), getAr());
	}
}
