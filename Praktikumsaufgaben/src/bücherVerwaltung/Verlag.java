package bücherVerwaltung;

public class Verlag {

	private String name;
	private String ort; //hier könnte es Redundanzen geben -> evtl. eigene Ortklassen
	
	public Verlag(String name, String ort) {
		setName(name);
		setOrt(ort);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	

}
