package bücherVerwaltung;

import java.util.ArrayList;
import java.util.List;

public class Autor implements Comparable<Autor>{ 
	
	private String vorName;
	private String nachName;
	private List<Buch> bücher;
	private List<Verlag> verläge;

	public Autor(String vorName, String nachName) {
		setVorName(vorName);
		setNachName(nachName);
		bücher = new ArrayList<Buch>();
		verläge = new ArrayList<Verlag>();
	}
	
	
	@Override
	public int compareTo(Autor otherAutor) {

		if(otherAutor == this) {
			return 0;
		}
		if(otherAutor.equals(this)) {
			return 0;
		}
//		Das Folgende ist nicht nötig, da in Parameterliste nur Autoren in Frage kommen.
//		if(! anotherAutor.getClass().equals(this.getClass())) {
//			throw new ClassCastException();
//		}
		if(! otherAutor.getNachName().equals(this.getNachName())) {
			return otherAutor.getNachName().compareTo(this.getNachName());
		}
		return  otherAutor.getVorName().compareTo(this.getVorName());
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
			if (this.getVorName().equals(otherAutor.getVorName()) &&
					this.getNachName().equals(otherAutor.getNachName())) {
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

	
	public void setBücher(List<Buch> bücher) {
		this.bücher = bücher;
	}
	
	
//	public void addBuchToAutor(Buch myBuch) {
//		this.bücher.add(myBuch);
//		myBuch.getAutoren().add(this);
//	}

//	for (int i = 0; i < verläge.size(); i++) {
//		for (int j = 0; j < this.autoren.size(); j++) {
//			verläge.get(i).getAutoren().add(this.autoren.get(j));
//		}
//	}
//	for (int i = 0; i < autoren.size(); i++) {
//		for (int j = 0; j < this.verläge.size(); j++) {
//			autoren.get(i).getVerläge().add(this.verläge.get(j));
//		}
//	}
	
	public List<Verlag> getVerläge() {
		return verläge;
	}

	
	public void setVerlag(List<Verlag> verläge) {
		this.verläge = verläge;
	}
	
	
//	public void addVerlagToAutor(Verlag myVerlag) {
//		this.verläge.add(myVerlag);
//		myVerlag.getAutoren().add(this);
//	}
}
