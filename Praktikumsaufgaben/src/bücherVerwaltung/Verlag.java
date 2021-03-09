package bücherVerwaltung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Verlag implements Comparable<Verlag>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1211381550724681446L;
	private String name;
	private String ort; //hier könnte es Redundanzen geben -> evtl. eigene Ortklassen (allerdings irrelevant bez. Zitieren)
	private Collection<Autor> autoren;
	private Collection<Buch> bücher;
	
	
	public Verlag(String name, String ort) {
		this.setName(name);
		this.setOrt(ort);
		this.autoren = new ArrayList<Autor>();
		this.bücher = new ArrayList<Buch>();
	}
	
	
	@Override
	public String toString() {
		return "Verlag [name=" + this.name + ", ort=" + this.ort + "]";
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
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrt() {
		return this.ort;
	}


	public void setOrt(String ort) {
		this.ort = ort;
	}


	public Collection<Autor> getAutoren() {
		return this.autoren;
	}


	public void setAutoren(Collection<Autor> autoren) {
		this.autoren = autoren;
	}


	public Collection<Buch> getBücher() {
		return this.bücher;
	}


	public void setBücher(Collection<Buch> bücher) {
		this.bücher = bücher;
	}
}
