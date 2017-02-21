package bolt;

import java.util.Date;

public abstract class Elelmiszer {
	protected long vonalKod;
	protected String gyarto;
	protected Date szavatossagiIdo;

	public Elelmiszer(long vonalKod, String gyarto, Date szavatossagiIdo) {
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
		this.szavatossagiIdo = szavatossagiIdo;
	}

	public abstract long getVonalKod();

	public abstract boolean joMeg();

	public abstract String getGyarto();

	public abstract Date getSzavatossagiIdo();

	@Override
	public abstract String toString();
}
