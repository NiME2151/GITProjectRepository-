
public class Spiel {
	
	private String id;
	private String titel;
	private String genre;
	private String veroeffentlichkeitsdatum;
	private String usk;
	private double preis;
	private int lageranzahl;
	private String verfuegbarkeit;
	private String sprache;
	
	public Spiel() {
		this.id = id;
		this.titel = titel;
		this.genre = genre;
		this.veroeffentlichkeitsdatum = veroeffentlichkeitsdatum;
		this.usk = usk;
		this.preis = preis;
		this.lageranzahl = lageranzahl;
		this.verfuegbarkeit = verfuegbarkeit;
		this.sprache = sprache;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
