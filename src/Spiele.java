

public class Spiele {
	
	private int id;
	private String titel;
	private String veroeffentlichkeitsdatum;
	private String usk;
	private double preis;
	private int lageranzahl;
	private String verfuegbarkeit;
	private String sprache;
	
	public Spiele() {
		this.id = id;
		this.titel = titel;
		this.veroeffentlichkeitsdatum = veroeffentlichkeitsdatum;
		this.usk = usk;
		this.preis = preis;
		this.lageranzahl = lageranzahl;
		this.verfuegbarkeit = verfuegbarkeit;
		this.sprache = sprache;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getVeroeffentlichkeitsdatum() {
		return veroeffentlichkeitsdatum;
	}

	public void setVeroeffentlichkeitsdatum(String veroeffentlichkeitsdatum) {
		this.veroeffentlichkeitsdatum = veroeffentlichkeitsdatum;
	}

	public String getUsk() {
		return usk;
	}

	public void setUsk(String usk) {
		this.usk = usk;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getLageranzahl() {
		return lageranzahl;
	}

	public void setLageranzahl(int lageranzahl) {
		this.lageranzahl = lageranzahl;
	}

	public String getVerfuegbarkeit() {
		return verfuegbarkeit;
	}

	public void setVerfuegbarkeit(String verfuegbarkeit) {
		this.verfuegbarkeit = verfuegbarkeit;
	}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	
}
