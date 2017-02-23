package bolt;

public abstract class Aru {
	protected Long vonalKod;
	protected String gyarto;

	public Aru(Long vonalKod, String gyarto) {
		this.vonalKod = vonalKod;
		this.gyarto = gyarto;
	}

	public abstract Long getVonalKod();

	public abstract String getGyarto();

	@Override
	public abstract String toString();
}
