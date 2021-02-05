package bücherVerwaltung;

public class BuchTyp {

	String bezeichnung;
	
	
	public BuchTyp(String input) {
		setBezeichnung(input);
	}

	
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	
}
