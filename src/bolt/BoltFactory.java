package bolt;

import java.util.Date;

import bolt.aruk.Sajt;
import bolt.aruk.Szappan;
import bolt.aruk.Tej;
import bolt.aruk.tej.FeltartosTej;
import bolt.aruk.tej.TartosTej;

public abstract class BoltFactory {
	public Tej ujTartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
	}

	public Tej ujfeltartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		return new FeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
	}

	public Sajt ujSajt(long vonalKod, double suly, String gyarto, Date szavatossagiIdo, double zsirtartatlom) {
		return new Sajt(vonalKod, zsirtartatlom, gyarto, szavatossagiIdo, zsirtartatlom);
	}

	public Szappan ujSzappan(long vonalKod, String gyarto, char mosohatas) {
		return new Szappan(vonalKod, gyarto, mosohatas);
	}
}
