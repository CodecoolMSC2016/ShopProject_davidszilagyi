package bolt;

import java.util.Date;

public abstract class Tej extends Elelmiszer {
	public final int LITER;
	public final int FELLITER;
	public final int POHAR;
	public final double ZSIROS;
	public final double FELZSIROS;
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
		return String.format("Gyártó: %s%nŰrtartalom: %d%nZsírtartalom: %f%nSzavatossagi idő: %tD", getGyarto(),
				getUrtartalom(), getZsirtartalom(), getSzavatossagiIdo());
	}
}
