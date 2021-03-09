package bücherVerwaltung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Autor implements Comparable<Autor>, Serializable{ 
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1801346095935276759L;
	private String vorName;
	private String nachName;
	private Collection<Buch> bücher;
	private Collection<Verlag> verläge;

	
	public Autor(String vorName, String nachName) {
		this.setVorName(vorName);
		this.setNachName(nachName);
		this.bücher = new ArrayList<Buch>();
		this.verläge = new ArrayList<Verlag>();
	}
	
	
	@Override
	public String toString() {
		return "Autor [vorName=" + this.vorName + ", nachName=" + this.nachName + "]";
	}


	@Override
	public int compareTo(Autor otherAutor) {
		if(otherAutor == this) {
			return 0;
		}
		if(otherAutor.equals(this)) {
			return 0;
		}
		int nachNamenVergleich = this.nachName.compareTo(otherAutor.getNachName());
		if(nachNamenVergleich != 0) {
			return nachNamenVergleich;
		}
		return this.vorName.compareTo(otherAutor.getVorName());
	}
	

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject ) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}
		if(otherObject.getClass().equals(this.getClass())) { //if (inputObject instanceof Autor) -> führt zu Problemen bei Sub- und Superclasses. In diesem Falle wäre es okay gewesen, da keine Superclass existiert.
			Autor otherAutor = (Autor) otherObject;
			if (this.vorName.equals(otherAutor.getVorName()) &&
					this.nachName.equals(otherAutor.getNachName())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		int hc = 17;
		int hashMultiplier = 79;
		for (int i = 0; i < this.vorName.charAt(0) % 13; i++) {
			hc = hc + hashMultiplier * this.vorName.charAt(this.vorName.length() - 1) -
					this.nachName.charAt(0) * this.nachName.charAt(this.nachName.length() - 1);
		}
		return hc;
	}


	public String getVorName() {
		return this.vorName;
	}


	public void setVorName(String vorName) {
		this.vorName = vorName;
	}


	public String getNachName() {
		return this.nachName;
	}


	public void setNachName(String nachName) {
		this.nachName = nachName;
	}


	public Collection<Buch> getBücher() {
		return this.bücher;
	}


	public void setBücher(Collection<Buch> bücher) {
		this.bücher = bücher;
	}


	public Collection<Verlag> getVerläge() {
		return this.verläge;
	}


	public void setVerläge(Collection<Verlag> verläge) {
		this.verläge = verläge;
	}
}
