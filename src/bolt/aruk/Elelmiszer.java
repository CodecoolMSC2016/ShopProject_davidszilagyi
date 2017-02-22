package bolt.aruk;

import java.util.Date;

import bolt.Aru;

public abstract class Elelmiszer extends Aru {

	protected Date szavatossagiIdo;

	public Elelmiszer(long vonalKod, String gyarto, Date szavatossagiIdo) {
		super(vonalKod, gyarto);
		this.szavatossagiIdo = szavatossagiIdo;
	}

	public abstract boolean joMeg();

	public abstract Date getSzavatossagiIdo();

}
