package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Buch implements Comparable<Buch>{

	private String titel;
	private String isbn;
	private int erscheinungsJahr;
	private Collection<Verlag> verläge;
	private BuchTyp buchTyp;
	private Collection<Autor> autoren;
	
	
	public Buch(String titel, String isbn, int erscheinungsJahr, Collection<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, Collection<Autor> beteiligteAutoren) {
		verläge = new ArrayList<Verlag>();
		autoren = new ArrayList<Autor>();
		setTitel(titel);
		setIsbn(isbn);
		setErscheinungsJahr(erscheinungsJahr);
		setVerläge(beteiligteVerläge);
		setBuchTyp(myBuchTyp);
		setAutoren(beteiligteAutoren);
	}


//	public Buch(String titel, String isbn, int erscheinungsJahr, Verlag verlag, BuchTyp buchTyp, Autor autor) {
//		verläge = new ArrayList<Verlag>();
//		autoren = new ArrayList<Autor>();
//		setTitel(titel);
//		setIsbn(isbn);
//		setErscheinungsJahr(erscheinungsJahr);
//		verläge.add(verlag);
//		setBuchTyp(buchTyp);
//		autoren.add(autor);
//	}
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
		int titelVergleich = this.titel.compareTo(anotherBuch.getTitel());
		if (titelVergleich != 0) {
			return titelVergleich;
		}
		int erscheinungsJahrVergleich = this.erscheinungsJahr - anotherBuch.getErscheinungsJahr();
		if (erscheinungsJahrVergleich != 0) {
			return erscheinungsJahrVergleich;
		}
		if (! this.autoren.equals(anotherBuch.getAutoren())) {
			TreeSet<Autor> anotherBuchAutorenSortiert = new TreeSet<>();
			TreeSet<Autor> thisBuchAutorenSortiert = new TreeSet<>();
			anotherBuchAutorenSortiert.addAll(anotherBuch.getAutoren());
			thisBuchAutorenSortiert.addAll(this.autoren);
			Iterator<Autor> itThisBuchAutoren = thisBuchAutorenSortiert.iterator();
			Iterator<Autor> itAnotherBuchAutoren = anotherBuchAutorenSortiert.iterator();
			int autorenVergleich = 0;
			while (itThisBuchAutoren.hasNext() && itAnotherBuchAutoren.hasNext()) {
				autorenVergleich = itThisBuchAutoren.next().compareTo(itAnotherBuchAutoren.next());
				if (autorenVergleich != 0) {
					return autorenVergleich;
				}
			}
			return itThisBuchAutoren.hasNext() ? 1 : -1;
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


	public Collection<Verlag> getVerläge() {
		return verläge;
	}


	public void setVerläge(Collection<Verlag> beteiligteVerläge) {
		this.verläge = beteiligteVerläge;
	}


	public BuchTyp getBuchTyp() {
		return buchTyp;
	}


	public void setBuchTyp(BuchTyp buchTyp) {
		this.buchTyp = buchTyp;
	}


	public Collection<Autor> getAutoren() {
		return autoren;
	}


	public void setAutoren(Collection<Autor> autoren) {
		this.autoren = autoren;
	}
	
}
