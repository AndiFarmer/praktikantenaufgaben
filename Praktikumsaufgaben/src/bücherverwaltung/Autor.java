package bücherverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Autor {
	
	private String vorname;
	private String nachname;
	private List<Buch> bücher = new ArrayList<Buch>();

	public Autor(String vorname, String nachname) {
		setVorname(vorname);
		setNachname(nachname);
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

	public void addBuch(Buch meinBuch) {
		this.bücher.add(meinBuch);
		meinBuch.setAutor(this);
	}
}
