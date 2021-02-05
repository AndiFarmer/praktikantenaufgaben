package bücherVerwaltung;

import java.util.ArrayList;
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
		
	}
	
	
//	public Buch() {
//		verläge = new ArrayList<Verlag>();
//		autoren = new ArrayList<Autor>();
//	}
	

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
	public boolean equals(Object anotherBuch) {
		if (this == anotherBuch ) {
			return true;
		}
		if (anotherBuch == null) {
			return false;
		}
		if (anotherBuch.getClass().equals(this.getClass())) { //if (inputObject instanceof Autor) -> führt zu Problemen bei Sub- und Superclasses. In diesem Falle wäre es okay gewesen, da keine Superclass existiert.
			Buch inputCasted = (Buch) anotherBuch;
			if (this.getTitel().equals(inputCasted.getTitel()) &&
					this.getAutoren().equals(inputCasted.getAutoren()) && //wenn die autoren zweier bücher nicht in der gleichen Reihenfolge stehen, dann werden sie nicht als nicht equal gesehen
						this.getErscheinungsJahr() == inputCasted.getErscheinungsJahr() ) {
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
			hc = hc * hashMultiplier + getAutoren().get(0).getVorName().charAt(0) * getAutoren().get(0).getVorName().charAt(getAutoren().get(0).getVorName().length() - 1) +
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
