
public class Kunde {

	

	private String vorname;
	private String nachname;
	private int IBAN;
	private String email;
	private String telefonnummer;
	private String ort;
	private String strasse;
	private int plz;
	
	
	public Kunde() {
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.IBAN = IBAN;
		this.email = email;
		this.telefonnummer = telefonnummer;
		this.ort = ort;
		this.strasse = strasse;
		this.plz = plz;
	}
	

	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public int getIBAN() {
		return IBAN;
	}


	public void setIBAN(int iBAN) {
		IBAN = iBAN;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefonnummer() {
		return telefonnummer;
	}


	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}


	public String getOrt() {
		return ort;
	}


	public void setOrt(String ort) {
		this.ort = ort;
	}


	public String getStrasse() {
		return strasse;
	}


	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}


	public int getPlz() {
		return plz;
	}


	public void setPlz(int plz) {
		this.plz = plz;
	}


}
