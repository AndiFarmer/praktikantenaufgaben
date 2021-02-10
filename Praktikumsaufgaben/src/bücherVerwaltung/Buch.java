package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Buch implements Comparable<Buch>{

	private String titel;
	private String isbn;
	private int erscheinungsJahr;
	private List<Verlag> verläge;
	private BuchTyp buchTyp;
	private List<Autor> autoren;
	
	
	public Buch(String titel, String isbn, int erscheinungsJahr, ArrayList<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, ArrayList<Autor> beteiligteAutoren) {
		verläge = new ArrayList<Verlag>();
		autoren = new ArrayList<Autor>();
		setTitel(titel);
		setIsbn(isbn);
		setErscheinungsJahr(erscheinungsJahr);
		setVerläge(beteiligteVerläge);
		setBuchTyp(myBuchTyp);
		setAutoren(beteiligteAutoren);
		
		adjustAutorenOfVerläge();
		adjustVerlägeOfAutoren();
	}


	public Buch(String titel, String isbn, int erscheinungsJahr, Verlag verlag, BuchTyp buchTyp, Autor autor) {
		verläge = new ArrayList<Verlag>();
		autoren = new ArrayList<Autor>();
		setTitel(titel);
		setIsbn(isbn);
		setErscheinungsJahr(erscheinungsJahr);
		verläge.add(verlag);
		setBuchTyp(buchTyp);
		autoren.add(autor);
		
		adjustAutorenOfVerläge();
		adjustVerlägeOfAutoren();
	}
	
	
//	public Buch() {
//		verläge = new ArrayList<Verlag>();
//		autoren = new ArrayList<Autor>();
//	}  !!! wenn ich die anderen Felder null lasse dann funktioniert die equals und compare methode nicht
	

	public void addAutorToBuch(Autor newAutor) {
		for (int i = 0; i < autoren.size(); i++) {
			if (newAutor.equals(autoren.get(i))) {
				return;
			}
		}
		autoren.add(newAutor);
		adjustAutorenOfVerläge();
		adjustVerlägeOfAutoren();
//		adjustAutorenOfVerläge(newAutor);
//		adjustVerlägeOfAutor(newAutor);
	}
	
	
	public void addVerlagToBuch(Verlag newVerlag) {
		for (int i = 0; i < verläge.size(); i++) {
			if (newVerlag.equals(verläge.get(i))) {
				return;
			}
		}
		verläge.add(newVerlag);
		adjustAutorenOfVerläge();
		adjustVerlägeOfAutoren();

	}
	
	
//	public void adjustAutorenOfVerläge(Autor autor) {
//		for (int i = 0; i < verläge.size(); i++) { // die Verläge des Buches durchgehen
//				for (int k = 0; k < verläge.get(i).getAutoren().size(); k++) { // die Autoren des aktuellen Verlages durchgehen, ob Autor eventuell schon in der Liste ist (durch andere Bücher)
//					if (verläge.get(i).getAutoren().get(k).equals(autor)) 
//						return;	
//				}
//				verläge.get(i).getAutoren().add(autor); 
//		}
//	}
//	
//	
//	public void adjustVerlägeOfAutor(Autor autor) {
//		
//			for (int j = 0; j < this.verläge.size(); j++) { 
//				for (int k = 0; k < autor.getVerläge().size(); k++) { 
//					if (autor.getVerläge().get(k).equals(verläge.get(j))) 
//						return;	
//				}
//				autor.getVerläge().add(verläge.get(j));
//			}
//		
//	}
	
	
	public void adjustAutorenOfVerläge() {
		for (Verlag verlag : verläge) { // get(i) nicht mehr nötig, stattdessen einfach verlag
			
		}
		
		Iterator<Verlag> meinVerlagsIterator = verläge.iterator();
		while (meinVerlagsIterator.hasNext()) {
			
			Verlag aktuellerVerlag = meinVerlagsIterator.next();
		}
		
		
		for (int i = 0; i < verläge.size(); i++) { // die Verläge des Buches durchgehen
			for (int j = 0; j < autoren.size(); j++) { // die Autoren des Buches zum aktuellen Verlag hinzufügen
				for (int k = 0; k < verläge.get(i).getAutoren().size(); k++) { // die Autoren des aktuellen Verlages durchgehen, ob Autoren eventuell schon in der Liste sind (durch andere Bücher)
					if (verläge.get(i).getAutoren().get(k).equals(autoren.get(j))) 
						return;	
				}
				verläge.get(i).getAutoren().add(autoren.get(j)); // falls der aktuelle Autor in der Liste des aktuellen Verlages noch nicht existiert, wird er an dieser Stelle hinzugefügt
			}
		}
	} // mitunter wäre eine Funktion, die doppelte Autoren löscht, einfacher als die Redundanz durch das vorherige Prüfen auszuschließen
	
	
	public void adjustVerlägeOfAutoren() {
		for (int i = 0; i < autoren.size(); i++) { // die Autoren des Buches durchgehen
			for (int j = 0; j < this.verläge.size(); j++) { // die Verläge des Buches zu dem aktuellen Autor hinzufügen
				for (int k = 0; k < autoren.get(i).getVerläge().size(); k++) { // die Verläge des aktuellen Autors durchgehen, ob Verläge eventuell schon in der Liste sind (durch andere Bücher)
					if (autoren.get(i).getVerläge().get(k).equals(verläge.get(j))) 
						return;	
				}
				autoren.get(i).getVerläge().add(verläge.get(j)); // falls der aktuelle Verlag in der Liste des aktuellen Autors noch nicht existiert, wird er an dieser Stelle hinzugefügt
			}
		}
	}
	
	
	@Override
	public int compareTo(Buch anotherBuch) {
		
		if (anotherBuch == this) {
			return 0;
		}
		if (anotherBuch.equals(this)) {
			return 0;
		}
		if (! anotherBuch.getTitel().equals(this.getTitel())) {
			return anotherBuch.getTitel().compareTo(this.getTitel());
		}
		if (! anotherBuch.getAutoren().equals(this.getAutoren())) {
			int zuVergleichendeAutorenAnzahl;
			if (anotherBuch.getAutoren().size() < this.getAutoren().size()) {
				zuVergleichendeAutorenAnzahl = this.getAutoren().size(); 
			} else {
				zuVergleichendeAutorenAnzahl = anotherBuch.getAutoren().size();
			}
			for (int i = 0; i < zuVergleichendeAutorenAnzahl; i++) {
				if (anotherBuch.getAutoren().get(i) == null) {
					return 1;
				}
				if (this.getAutoren().get(i) == null) {
					return -1;
				}
				if (anotherBuch.getAutoren().get(i).compareTo(this.getAutoren().get(i)) != 0) {
					return anotherBuch.getAutoren().get(i).compareTo(this.getAutoren().get(i));
				}
			}
			
		}
		if (anotherBuch.getErscheinungsJahr() < this.getErscheinungsJahr()) {
			return 1;
		}
		if (anotherBuch.getErscheinungsJahr() > this.getErscheinungsJahr()) {
			return -1;
		}
		return 0;
	}
	

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject ) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}
		if (otherObject.getClass().equals(this.getClass())) { //if (inputObject instanceof Autor) -> führt zu Problemen bei Sub- und Superclasses. In diesem Falle wäre es okay gewesen, da keine Superclass existiert.
			Buch otherBuch = (Buch) otherObject;
			if (this.getTitel().equals(otherBuch.getTitel()) &&
					this.getAutoren().equals(otherBuch.getAutoren()) && //wenn die autoren zweier bücher nicht in der gleichen Reihenfolge stehen, dann werden sie nicht als nicht equal gesehen
						this.getErscheinungsJahr() == otherBuch.getErscheinungsJahr() ) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		int hc = 17;
		int hashMultiplier = 59;
		for (int i = 0; i < this.erscheinungsJahr * this.titel.length() % 137; i++) { 
			hc = hc * hashMultiplier + getAutoren().get(0).getVorName().charAt(0) * getAutoren().get(0).getVorName().charAt(getAutoren().get(0).getVorName().length() - 1) -
					getAutoren().get(0).getNachName().charAt(0) * getAutoren().get(0).getNachName().charAt(getAutoren().get(0).getNachName().length() - 1);
		}
		return hc;
	}

	
	public String getTitel() {
		return titel;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getErscheinungsJahr() {
		return erscheinungsJahr;
	}


	public void setErscheinungsJahr(int erscheinungsJahr) {
		this.erscheinungsJahr = erscheinungsJahr;
	}


	public List<Verlag> getVerläge() {
		return verläge;
	}


	public void setVerläge(List<Verlag> verläge) {
		this.verläge = verläge;
	}


	public BuchTyp getBuchTyp() {
		return buchTyp;
	}


	public void setBuchTyp(BuchTyp buchTyp) {
		this.buchTyp = buchTyp; // es wird nur eine Referenz auf das Objekt (vom Typ BuchTyp) auf das buchTyp zeigt übergeben -> wenn sich das Objekt inhaltlich ändern sollte, dann lässt sich diese Änderung auch über dieses Buch feststellen
	}


	public List<Autor> getAutoren() {
		return autoren;
	}


	public void setAutoren(List<Autor> autoren) {
		this.autoren = autoren;
	}
	

}
