package bolt;

public abstract class Aru {
	protected long vonalKod;
	protected String gyarto;

	public Aru(long vonalKod, String gyarto) {
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
	}

	public abstract long getVonalKod();

	public abstract String getGyarto();

	@Override
	public abstract String toString();
}
