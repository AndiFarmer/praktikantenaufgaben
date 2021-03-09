package bücherVerwaltung;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class Buch implements Comparable<Buch>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1371793923681604058L;
	private String titel;
	private String isbn;
	private int erscheinungsJahr;
	private Collection<Verlag> verläge;
	private BuchTyp buchTyp;
	private Collection<Autor> autoren;
	
	
	public Buch(String titel, String isbn, int erscheinungsJahr, Collection<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, Collection<Autor> beteiligteAutoren) {
		this.setTitel(titel);
		this.setIsbn(isbn);
		this.setErscheinungsJahr(erscheinungsJahr);
		this.setVerläge(beteiligteVerläge);
		this.setBuchTyp(myBuchTyp);
		this.setAutoren(beteiligteAutoren);
	}

	
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		Iterator<Autor> autorenIt = this.autoren.iterator();
//		Autor autorTmp = new Autor("", "");
//		while (autorenIt.hasNext()) {
//			autorTmp = autorenIt.next();
//			sb.append(autorTmp.getVorName() + " ");
//			sb.append(autorTmp.getNachName());
//			sb.append((autorenIt.hasNext() ? " & " : ""));
//		}
//		StringBuilder sb2 = new StringBuilder();
//		Iterator<Verlag> verlägeIt2 = this.verläge.iterator();
//		Verlag verlagTmp2 = new Verlag("", "");
//		while (verlägeIt2.hasNext()) {
//			verlagTmp2 = verlägeIt2.next();
//			sb2.append(verlagTmp2.getName() + " ");
//			sb2.append(verlagTmp2.getOrt());
//			sb2.append((verlägeIt2.hasNext() ? " & " : ""));
//		}
//		return "Titel: " + "'" + this.titel + "', " + "Erscheinungsjahr: " + this.erscheinungsJahr + ", Autor/en: " + sb.toString() + ", Verläge: " + sb2.toString();
//	}
	
	
	@Override
	public String toString() {
		return "Buch [titel=" + this.titel + ", erscheinungsJahr=" + this.erscheinungsJahr + ", verläge=" + this.verläge + ", autoren="
				+ this.autoren + "]";
	}
	
	
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Buch other = (Buch) obj;
		if (this.autoren == null) {
			if (other.autoren != null) {
				return false;
			}
		} else if (!this.autoren.equals(other.autoren)) {
			return false;
		}
		if (this.erscheinungsJahr != other.erscheinungsJahr) {
			return false;
		}
		if (this.titel == null) {
			if (other.titel != null) {
				return false;
			}
		} else if (!this.titel.equals(other.titel)) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public int hashCode() {
		int hc = 1;
		int hashMultiplier = 31;
		
		char[] titelArray = this.titel.toCharArray();
		int titelAlsZahl = 0;
		int verlagAlsZahl = 0;
		
		for (char c : titelArray) { 
			titelAlsZahl += c;
		}
		for (Verlag verlag : this.verläge) {
			verlagAlsZahl = verlagAlsZahl += verlag.getName().charAt(0);
		}
		
		hc = hashMultiplier * hc + titelAlsZahl;
		hc = hashMultiplier * hc + this.erscheinungsJahr;
		hc = hashMultiplier * hc + verlagAlsZahl;
		return hc;
	}


	public String getTitel() {
		return this.titel;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}


	public String getIsbn() {
		return this.isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getErscheinungsJahr() {
		return this.erscheinungsJahr;
	}


	public void setErscheinungsJahr(int erscheinungsJahr) {
		this.erscheinungsJahr = erscheinungsJahr;
	}


	public Collection<Verlag> getVerläge() {
		return this.verläge;
	}


	public void setVerläge(Collection<Verlag> beteiligteVerläge) {
		this.verläge = beteiligteVerläge;
	}


	public BuchTyp getBuchTyp() {
		return this.buchTyp;
	}


	public void setBuchTyp(BuchTyp buchTyp) {
		this.buchTyp = buchTyp;
	}


	public Collection<Autor> getAutoren() {
		return this.autoren;
	}


	public void setAutoren(Collection<Autor> autoren) {
		this.autoren = autoren;
	}
}
