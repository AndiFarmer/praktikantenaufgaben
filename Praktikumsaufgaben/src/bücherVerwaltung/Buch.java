package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Buch implements Comparable<Buch>{

	private String titel;
	private String isbn;
	private int erscheinungsJahr;
	private Collection<Verlag> verläge;
	private BuchTyp buchTyp;
	private Collection<Autor> autoren;
	
	private CollectionAdjuster myCollectionAdjuster;
	
	
	public Buch(String titel, String isbn, int erscheinungsJahr, Set<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, Set<Autor> beteiligteAutoren) {
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
	

	public void addAutorToBuch(Autor newAutor) {
	
	}
	
	
	public void addVerlagToBuch(Verlag newVerlag) {

	}
	

	public void customizeBuch() {
		
	}
//	public void adjustAutorenOfVerläge_VerlägeVonDiesemBuch() {
//		for (Verlag verlag : verläge) { // die Verläge dieses Buches durchgehen
//			for (Autor autor : autoren) { // die Autoren von diesem Buch durchgehen
//				if (! verlag.getAutoren().contains(autor)) { // prüfen ob die Autoren im Verlag den aktuellen Autor schon innehaben
//					verlag.getAutoren().add(autor);	
//				}
//			}
//		}
//		Iterator<Verlag> meinVerlagsIterator = verläge.iterator();
//		while (meinVerlagsIterator.hasNext()) {
//			
//			Verlag aktuellerVerlag = meinVerlagsIterator.next();
//		}
//	} 
	
	
	@Override
	public int compareTo(Buch anotherBuch) {
		
		if (anotherBuch == this) {
			return 0;
		}
		if (anotherBuch.equals(this)) {
			return 0;
		}
		if (! this.titel.equals(anotherBuch.getTitel())) {
			return this.titel.compareTo(anotherBuch.getTitel());
		}
		if (this.erscheinungsJahr < anotherBuch.getErscheinungsJahr()) {
			return -1;
		} else if (this.erscheinungsJahr > anotherBuch.getErscheinungsJahr()) {
			return 1;
		}
		if (! this.autoren.equals(anotherBuch.getAutoren())) {
			int zuVergleichendeAutorenAnzahl;
			ArrayList<Autor> anotherBuchAutorenList = new ArrayList<>();
			ArrayList<Autor> thisBuchAutorenList = new ArrayList<>();
			
			anotherBuchAutorenList.addAll(anotherBuch.getAutoren());
			thisBuchAutorenList.addAll(this.autoren);
			zuVergleichendeAutorenAnzahl = (anotherBuchAutorenList.size() > thisBuchAutorenList.size() ? anotherBuchAutorenList.size() : thisBuchAutorenList.size());
			anotherBuchAutorenList.sort(null);
			thisBuchAutorenList.sort(null);
			
			int vergleichErgebnis = 0;
			for (int i = 0; i < zuVergleichendeAutorenAnzahl; i++) {
				vergleichErgebnis = thisBuchAutorenList.get(i).compareTo(anotherBuchAutorenList.get(i));
				if ( vergleichErgebnis != 0) {
					return vergleichErgebnis;
				}
			}
		}

		System.out.println("Eigentlich dürfte das Programm nicht bis hierhin kommen. Schauen Sie in den Code von CompareTo von Buch"); 
		return 0; 
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buch other = (Buch) obj;
		if (autoren == null) {
			if (other.autoren != null)
				return false;
		} else if (!autoren.equals(other.autoren))
			return false;
		if (erscheinungsJahr != other.erscheinungsJahr)
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}
	
	
	@Override
	public int hashCode() {
		int hc = 1;
		int hashMultiplier = 31;
		
		char[] titelArray = titel.toCharArray();
		int titelAlsZahl = 0;
		
		for (char c : titelArray) { 
			titelAlsZahl += c;
		}
		
		hc = hashMultiplier * hc + titelAlsZahl;
		hc = hashMultiplier * hc + erscheinungsJahr;
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
