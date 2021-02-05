package bücherVerwaltung;

import java.util.ArrayList;
import java.util.List;

public class Autor implements Comparable<Autor>{ 
	
	private String vorName;
	private String nachName;
	private List<Buch> bücher;

	public Autor(String vorName, String nachName) {
		setVorName(vorName);
		setNachName(nachName);
		bücher = new ArrayList<Buch>();
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public List<Buch> getBücher() {
		return bücher;
	}

	public void addBuchToAutor(Buch myBuch) {
		this.bücher.add(myBuch);
		myBuch.setAutor(this);
	}

	
	@Override
	public final int compareTo(Autor anotherAutor) {

		if(anotherAutor.equals(this)) { // oder wie bei Angelika Langer another == this?
			return 0;
		}
		if(! anotherAutor.getClass().equals(this.getClass())) {
			throw new ClassCastException();
		}
		if(! anotherAutor.nachName.equals(this.nachName)) {
			return anotherAutor.nachName.compareTo(this.nachName);
		}
		return  anotherAutor.vorName.compareTo(this.vorName);
	}
	

	@Override
	public final boolean equals(Object anotherAutor) {
		if (this == anotherAutor ) {
			return true;
		}
		if (anotherAutor == null) {
			return false;
		}
		if(anotherAutor.getClass().equals(this.getClass())) { //if (inputObject instanceof Autor) -> führt zu Problemen bei Sub- und Superclasses. In diesem Falle wäre es okay gewesen, da keine Superclass existiert.
			Autor inputCasted = (Autor) anotherAutor;
			if (this.getVorName().equals(inputCasted.getVorName()) &&
					this.getNachName().equals(inputCasted.getNachName())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public final int hashCode() {
		int hc = 17;
		int hashMultiplier = 59;
		for (int i = 0; i < this.vorName.charAt(0) % 13; i++) {
			hc = hc * hashMultiplier + this.vorName.charAt(vorName.length() - 1) *
					this.nachName.charAt(0) + this.nachName.charAt(nachName.length() - 1);
		}
		return hc;	
	}
	
}
