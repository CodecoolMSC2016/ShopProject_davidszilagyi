package bolt;

import java.util.Date;

public abstract class TejFactory {
	public abstract Tej ujTartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo,
			double zsirtartalom, long ar);

	public abstract Tej ujfeltartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo,
			double zsirtartalom, long ar);
}
