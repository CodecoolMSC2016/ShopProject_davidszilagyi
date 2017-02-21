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

	public int getUrtartalom() {
		return urtartalom;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	@Override
	public String toString() {
		return String.format("Gyártó: %s%nZsírtartalom: %.1f%nŰrtartalom: %d%n Szavatossági Idő: %tD%n", getGyarto(),
				getZsirtartalom(), getUrtartalom(), getSzavatossagiIdo());
	}
}
