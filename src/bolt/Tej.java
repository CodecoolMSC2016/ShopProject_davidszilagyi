package bolt;

import java.util.Date;

public abstract class Tej {
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

	public Tej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		this.urtartalom = urtartalom;
		this.gyarto = gyarto;
		this.szavatossagiIdo = szavatossagiIdo;
		this.zsirtartalom = zsirtartalom;
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

	@Override
	public String toString() {
		return String.format("Gyártó: %s%nŰrtartalom: %d%nZsírtartalom: %f%nSzavatossagi idő: %tD", getGyarto(),
				getUrtartalom(), getZsirtartalom(), getSzavatossagiIdo());
	}
}
