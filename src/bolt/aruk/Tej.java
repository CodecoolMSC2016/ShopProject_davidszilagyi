package bolt.aruk;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Tej extends Elelmiszer {
	protected int urtartalom;
	protected double zsirtartalom;

	public Tej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		super(vonalKod, gyarto, szavatossagiIdo);
		this.urtartalom = urtartalom;
		this.zsirtartalom = zsirtartalom;
	}

	@Override
	public long getVonalKod() {
		return vonalKod;
	}

	@Override
	public boolean joMeg() {
		return new Date().before(getSzavatossagiIdo());
	}

	public int getUrtartalom() {
		return urtartalom;
	}

	@Override
	public String getGyarto() {
		return gyarto;
	}

	@Override
	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		return String.format("Gyártó: %s%nŰrtartalom: %d%nZsírtartalom: %.2f%nSzavatossagi idő: %s", getGyarto(),
				getUrtartalom(), getZsirtartalom(), sdf.format(getSzavatossagiIdo()));
	}
}
