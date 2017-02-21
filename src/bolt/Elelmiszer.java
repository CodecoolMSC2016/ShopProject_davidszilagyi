package bolt;

import java.util.Date;

public class Elelmiszer {
	protected long vonalKod;
	protected String gyarto;
	protected Date szavatossagiIdo;

	public Elelmiszer(long vonalKod, String gyarto, Date szavatossagiIdo) {
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
		this.szavatossagiIdo = szavatossagiIdo;
	}

	public long getVonalKod() {
		return vonalKod;
	}

	public boolean joMeg() {
		return true;
	}

	public String getGyarto() {
		return gyarto;
	}

	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	@Override
	public String toString() {
		return String.format("Gyártó: %s%nSzavatossági Idő: %tD%n", getGyarto(), getSzavatossagiIdo());
	}

}
