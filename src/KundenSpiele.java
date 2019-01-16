
public class KundenSpiele {
	
	private int id;
	private String spieltitel;
	private String spielRelease;
	private String kundennachname;
	private String kundenIBAN;
	private double preis;
	private String menge;
	private String faelligkeitsdatum;
	private String ausleihdatum;
	
	public KundenSpiele() {
		this.id = id;
		this.spieltitel = spieltitel;
		this.spielRelease = spielRelease;
		this.kundennachname = kundennachname;
		this.kundenIBAN = kundenIBAN;
		this.preis = preis;
		this.menge = menge;
		this.faelligkeitsdatum = faelligkeitsdatum;
		this.ausleihdatum = ausleihdatum;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpieltitel() {
		return spieltitel;
	}
	public void setSpieltitel(String spieltitel) {
		this.spieltitel = spieltitel;
	}
	public String getSpielRelease() {
		return spielRelease;
	}
	public void setSpielRelease(String spielRelease) {
		this.spielRelease = spielRelease;
	}
	public String getKundennachname() {
		return kundennachname;
	}
	public void setKundennachname(String kundennachname) {
		this.kundennachname = kundennachname;
	}
	public String getKundenIBAN() {
		return kundenIBAN;
	}
	public void setKundenIBAN(String kundenIBAN) {
		this.kundenIBAN = kundenIBAN;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getMenge() {
		return menge;
	}
	public void setMenge(String menge) {
		this.menge = menge;
	}
	public String getFaelligkeitsdatum() {
		return faelligkeitsdatum;
	}
	public void setFaelligkeitsdatum(String faelligkeitsdatum) {
		this.faelligkeitsdatum = faelligkeitsdatum;
	}
	public String getAusleihdatum() {
		return ausleihdatum;
	}
	public void setAusleihdatum(String ausleihdatum) {
		this.ausleihdatum = ausleihdatum;
	}
	
	

}
