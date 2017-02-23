package bolt.aruk;

import bolt.Aru;

public class Szappan extends Aru {
	protected char mosohatas;

	public Szappan(long vonalKod, String gyarto, char mosohatas) {
		super(vonalKod, gyarto);
		this.mosohatas = mosohatas;
	}

	@Override
	public long getVonalKod() {
		return vonalKod;
	}

	@Override
	public String getGyarto() {
		return gyarto;
	}

	public char getMosohatas() {
		return mosohatas;
	}

	@Override
	public String toString() {
		return String.format("Gyártó: %s%nMosohatás: %s%nVonalKód: %d", getGyarto(), getMosohatas(), getVonalKod());
	}
}
