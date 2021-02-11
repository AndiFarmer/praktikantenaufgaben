package bücherVerwaltung;

import java.util.HashSet;
import java.util.Set;

public class Buch implements Comparable<Buch>{

	private String titel;
	private String isbn;
	private int erscheinungsJahr;
	private Set<Verlag> verläge;
	private BuchTyp buchTyp;
	private Set<Autor> autoren;
	
	
	public Buch(String titel, String isbn, int erscheinungsJahr, Set<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, Set<Autor> beteiligteAutoren) {
		verläge = new HashSet<Verlag>();
		autoren = new HashSet<Autor>();
		setTitel(titel);
		setIsbn(isbn);
		setErscheinungsJahr(erscheinungsJahr);
		setVerläge(beteiligteVerläge);
		setBuchTyp(myBuchTyp);
		setAutoren(beteiligteAutoren);

	}


	public Buch(String titel, String isbn, int erscheinungsJahr, Verlag verlag, BuchTyp buchTyp, Autor autor) {
		verläge = new HashSet<Verlag>();
		autoren = new HashSet<Autor>();
		setTitel(titel);
		setIsbn(isbn);
		setErscheinungsJahr(erscheinungsJahr);
		verläge.add(verlag);
		setBuchTyp(buchTyp);
		autoren.add(autor);
		

	}
	

	public void addAutorToBuch(Autor newAutor) {
	
	}
	
	
	public void addVerlagToBuch(Verlag newVerlag) {

	}
	

	public void adjustAutorenOfVerläge_VerlägeVonDiesemBuch() {
		for (Verlag verlag : verläge) { // die Verläge dieses Buches durchgehen
			for (Autor autor : autoren) { // die Autoren von diesem Buch durchgehen
				if (! verlag.getAutoren().contains(autor)) { // prüfen ob die Autoren im Verlag den aktuellen Autor schon innehaben
					verlag.getAutoren().add(autor);	
				}
			}
		}
//		Iterator<Verlag> meinVerlagsIterator = verläge.iterator();
//		while (meinVerlagsIterator.hasNext()) {
//			
//			Verlag aktuellerVerlag = meinVerlagsIterator.next();
//		}
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


	public Set<Verlag> getVerläge() {
		return verläge;
	}


	public void setVerläge(Set<Verlag> verläge) {
		this.verläge = verläge;
	}


	public BuchTyp getBuchTyp() {
		return buchTyp;
	}


	public void setBuchTyp(BuchTyp buchTyp) {
		this.buchTyp = buchTyp;
	}


	public Set<Autor> getAutoren() {
		return autoren;
	}


	public void setAutoren(Set<Autor> autoren) {
		this.autoren = autoren;
	}
	
}
