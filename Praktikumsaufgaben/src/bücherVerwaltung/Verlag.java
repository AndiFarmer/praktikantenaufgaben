package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;

public class Verlag implements Comparable<Verlag> {

	private String name;
	private String ort; //hier könnte es Redundanzen geben -> evtl. eigene Ortklassen (allerdings irrelevant bez. Zitieren)
	private Collection<Autor> autoren;
	private Collection<Buch> bücher;
	
	
	public Verlag(String name, String ort) {
		setName(name);
		setOrt(ort);
		autoren = new ArrayList<Autor>();
		bücher = new ArrayList<Buch>();
	}

	
	@Override
	public String toString() {
		return "Verlagsname: " + name + ", Ort: " + ort;
	}
	
	
	@Override
	public int compareTo(Verlag otherVerlag) {
		if (this.equals(otherVerlag)) {
			return 0;
		}
		if (otherVerlag == this) {
			return 0;
		}
		int namenVergleich = this.name.compareTo(otherVerlag.getName());
		if (namenVergleich != 0) {
			return namenVergleich;
		}
		return this.ort.compareTo(otherVerlag.getOrt());
	}
	
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		if (otherObject == this) {
			return true;
		}
		if (otherObject.getClass() == this.getClass()) {
			Verlag otherVerlag = (Verlag) otherObject;
			if (otherVerlag.getName().equals(this.getName()) 
					&& otherVerlag.getOrt().equals(this.getOrt())) {
				return true;
			}
		}
		return false;
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


	public Collection<Autor> getAutoren() {
		return autoren;
	}


	public void setAutoren(Collection<Autor> autoren) {
		this.autoren = autoren;
	}


	public Collection<Buch> getBücher() {
		return bücher;
	}


	public void setBücher(Collection<Buch> bücher) {
		this.bücher = bücher;
	}
}
