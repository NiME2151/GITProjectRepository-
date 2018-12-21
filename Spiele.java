
public class Spiele {


	private String titel;
	private double preisProTag;
	private String veroeffentlichkeitsdatum;
	private String genre;
	private int uskFreigabe;
	private int lageranzahl;
	private int verfuegbarkeit;
	private double spielzeit;
	private String sprache;





	public Spiele (String titel, double preisProTag, String veroeffentlichkeitsdatum, String genre,
			int uskFreigabe, int lageranzahl, int verfuegbarkeit, int spielzeit, String sprache) {
		super();
		this.titel = titel;
		this.preisProTag = preisProTag;
		this.veroeffentlichkeitsdatum = veroeffentlichkeitsdatum;
		this.genre = genre;
		this.uskFreigabe = uskFreigabe;
		this.lageranzahl = lageranzahl;
		this.verfuegbarkeit = verfuegbarkeit;
		this.spielzeit = spielzeit;
		this.sprache = sprache;
	}
	
	public Spiele () {
		super();
	}
	
	
	public String getTitel() {
		return titel; 
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public double getPreisProTag() {
		return preisProTag;
	}
	public void setPreisProTag(double preisProTag) {
		this.preisProTag = preisProTag;
	}
	public String getVeroeffentlichkeitsdatum() {
		return veroeffentlichkeitsdatum;
	}
	public void setVeroeffentlichkeitsdatum(String veroeffentlichkeitsdatum) {
		this.veroeffentlichkeitsdatum = veroeffentlichkeitsdatum;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getUskFreigabe() {
		return uskFreigabe;
	}
	public void setUskFreigabe(int uskFreigabe) {
		this.uskFreigabe = uskFreigabe;
	}
	public int getLageranzahl() {
		return lageranzahl;
	}
	public void setLageranzahl(int lageranzahl) {
		this.lageranzahl = lageranzahl;
	}
	public int getVerfuegbarkeit() {
		return verfuegbarkeit;
	}
	public void setVerfuegbarkeit(int verfuegbarkeit) {
		this.verfuegbarkeit = verfuegbarkeit;
	}
	public double getSpielzeit() {
		return spielzeit;
	}
	public void setSpielzeit(double spielzeit) {
		this.spielzeit = spielzeit;
	}
	public String getSprache() {
		return sprache;
	}
	public void setSprache(String sprache) {
		this.sprache = sprache;
	}


}




