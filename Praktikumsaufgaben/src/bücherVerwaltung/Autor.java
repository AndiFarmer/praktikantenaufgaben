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
	
	
	@Override
	public int compareTo(Autor anotherAutor) {

		if(anotherAutor == this) {
			return 0;
		}
		if(anotherAutor.equals(this)) {
			return 0;
		}
//		Das Folgende ist nicht nötig, da in Parameterliste nur Autoren in Frage kommen.
//		if(! anotherAutor.getClass().equals(this.getClass())) {
//			throw new ClassCastException();
//		}
		if(! anotherAutor.getNachName().equals(this.getNachName())) {
			return anotherAutor.getNachName().compareTo(this.getNachName());
		}
		return  anotherAutor.getVorName().compareTo(this.getVorName());
	}
	

	@Override
	public boolean equals(Object anotherAutor) {
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
	public int hashCode() {
		int hc = 17;
		int hashMultiplier = 59;
		for (int i = 0; i < this.vorName.charAt(0) % 13; i++) {
			hc = hc * hashMultiplier + this.vorName.charAt(this.vorName.length() - 1) *
					this.nachName.charAt(0) + this.nachName.charAt(this.nachName.length() - 1);
		}
		return hc;
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
		myBuch.getAutoren().add(this);
	}

	
	
}
