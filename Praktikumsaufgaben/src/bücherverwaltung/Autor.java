package bücherverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Autor { //implements Comparable<Autor>
	
	private String vorname;
	private String nachname;
	private List<Buch> bücher;

	public Autor(String vorname, String nachname) {
		setVorname(vorname);
		setNachname(nachname);
		bücher = new ArrayList<Buch>();
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

	public List<Buch> getBücher() {
		return bücher;
	}

	public void addBuchToAutor(Buch myBuch) {
		this.bücher.add(myBuch);
		myBuch.setAutor(this);
	}

//	@Override
//	public int compareTo(Autor o) {
//
//		if(this.getVorname().equals(o.getVorname()) && this.getNachname().equals(o.getNachname())) {
//			return 0;
//		}
//		return 1;
//		
//	}
	

	@Override
	public boolean equals(Object inputObject) {
		if (this == inputObject ) {
			return true;
		}
		if (inputObject == null) {
			return false;
		}
		if (inputObject instanceof Autor) {
			Autor inputCasted = (Autor) inputObject;
			if (this.getVorname().equals(inputCasted.getVorname()) &&
					this.getNachname().equals(inputCasted.getNachname())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		int hc = 17;
		int hashMultiplier = 59;
		for (int i = 0; i < this.vorname.charAt(0) % 13; i++) {
			hc = hc * hashMultiplier + this.vorname.charAt(vorname.length() - 1) *
					this.nachname.charAt(0) + this.nachname.charAt(nachname.length() - 1);
		}
		return hc;	
	}
	
}
