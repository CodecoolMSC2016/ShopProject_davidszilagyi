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

	public Tej ujFeltartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
		return new FeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
	}

	public Tej ujFelzsirosTartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, 1.0);
	}

	public Tej ujZsirosTartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
		return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, 2.0);
	}

	public Tej ujFelzsirosFeltartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
		return new FeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, 1.0);
	}

	public Tej ujZsirosFeltartosTej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
		return new FeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, 2.0);
	}

	public Tej ujFelzsirosLiteresTartosTej(long vonalKod, String gyarto, Date szavatossagiIdo) {
		return new TartosTej(vonalKod, 1, gyarto, szavatossagiIdo, 1.0);
	}

	public Tej ujZsirosLiteresTartosTej(long vonalKod, String gyarto, Date szavatossagiIdo) {
		return new TartosTej(vonalKod, 1, gyarto, szavatossagiIdo, 2.0);
	}

	public Tej ujFelzsirosLiteresFeltartosTej(long vonalKod, String gyarto, Date szavatossagiIdo) {
		return new FeltartosTej(vonalKod, 1, gyarto, szavatossagiIdo, 1.0);
	}

	public Tej ujZsirosLiteresFeltartosTej(long vonalKod, String gyarto, Date szavatossagiIdo) {
		return new FeltartosTej(vonalKod, 1, gyarto, szavatossagiIdo, 2.0);
	}

	public Sajt ujSajt(long vonalKod, double suly, String gyarto, Date szavatossagiIdo, double zsirtartatlom) {
		return new Sajt(vonalKod, zsirtartatlom, gyarto, szavatossagiIdo, zsirtartatlom);
	}

	public Szappan ujSzappan(long vonalKod, String gyarto, char mosohatas) {
		return new Szappan(vonalKod, gyarto, mosohatas);
	}

	public Szappan ujAMosohatasuSzappan(long vonalKod, String gyarto) {
		return new Szappan(vonalKod, gyarto, 'A');
	}
}
