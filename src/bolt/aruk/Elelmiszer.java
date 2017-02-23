package bolt.aruk;

import java.text.SimpleDateFormat;
import java.util.Date;

import bolt.Aru;

public abstract class Elelmiszer extends Aru {

	protected Date szavatossagiIdo;
	protected SimpleDateFormat sdf;

	public Elelmiszer(Long vonalKod, String gyarto, Date szavatossagiIdo) {
		super(vonalKod, gyarto);
		this.szavatossagiIdo = szavatossagiIdo;
		this.sdf = new SimpleDateFormat("yyyy/MM/dd");
	}

	public abstract boolean joMeg();

	public abstract Date getSzavatossagiIdo();

}
