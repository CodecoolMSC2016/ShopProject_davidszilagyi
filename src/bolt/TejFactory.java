package bolt;

import java.util.Date;

public abstract class TejFactory {
	public Tej ujTartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		Tej tartosTej = new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
		return tartosTej;
	}

	public Tej ujFeltartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		Tej feltartosTej = new FeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
		return feltartosTej;
	}
}
