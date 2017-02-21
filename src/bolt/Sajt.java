package bolt;

import java.util.Date;

public class Sajt {
	protected double suly;
	protected double zsirtartalom;
	protected long vonalKod;
	protected String gyarto;
	protected Date szavatossagiIdo;

	public Sajt(long vonalKod, double suly, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		this.vonalKod = vonalKod;
		this.suly = suly;
		this.gyarto = gyarto;
		this.szavatossagiIdo = szavatossagiIdo;
		this.zsirtartalom = zsirtartalom;
	}

	public double getSuly() {
		return suly;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	@Override
	public String toString() {
		return String.format("Gyártó: %s%nZsírtartalom: %.1f%nSúly: %d%n Szavatossági Idő: %tD%n", getGyarto(),
				getZsirtartalom(), getSuly(), getSzavatossagiIdo());
	}

	public boolean joMeg() {
		return true;
	}

	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	public long getVonalKod() {
		return vonalKod;
	}

	public String getGyarto() {
		return gyarto;
	}
}
