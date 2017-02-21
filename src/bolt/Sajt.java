package bolt;

import java.util.Date;

public class Sajt extends Elelmiszer {
	protected double suly;
	protected double zsirtartalom;

	public Sajt(long vonalKod, double suly, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		super(vonalKod, gyarto, szavatossagiIdo);
		this.suly = suly;
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
		return String.format("Gyártó: %s%nSúly: %d%nZsírtartalom: %f%nSzavatossagi idő: %tD", getGyarto(), getSuly(),
				getZsirtartalom());
	}

	@Override
	public boolean joMeg() {
		return new Date().before(getSzavatossagiIdo());
	}

	@Override
	public Date getSzavatossagiIdo() {
		return szavatossagiIdo;
	}

	@Override
	public long getVonalKod() {
		return vonalKod;
	}

	@Override
	public String getGyarto() {
		return gyarto;
	}
}
