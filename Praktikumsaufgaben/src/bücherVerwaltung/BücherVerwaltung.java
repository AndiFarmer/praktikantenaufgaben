package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BücherVerwaltung {
	
	private AutorenVerwalter autorenVerwalter;
	private VerlagVerwalter verlagVerwalter;
	private BuchTypVerwalter buchTypVerwalter;
	
	private CollectionAdjuster collectionAdjuster;
	
	private Collection<Buch> bücher;
	
	private Collection<Autor> autoren;
	private Collection<Verlag> verläge;
	private Collection<BuchTyp> buchTypen;
	
	
	public BücherVerwaltung() {
		this.autorenVerwalter = new AutorenVerwalter(this);
		this.verlagVerwalter = new VerlagVerwalter(this);
		this.buchTypVerwalter = new BuchTypVerwalter(this);
		this.collectionAdjuster = new CollectionAdjuster(this);
		this.bücher = new ArrayList<Buch>();
		this.autoren = new ArrayList<Autor>();
		this.verläge = new ArrayList<Verlag>();
		this.buchTypen = new ArrayList<BuchTyp>();
	}

	
	public boolean addNewBuch(String titel, String isbn, int erscheinungsJahr, Collection<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, Collection<Autor> beteiligteAutoren) {
		Buch neuesBuch = new Buch(titel, isbn, erscheinungsJahr, beteiligteVerläge, myBuchTyp, beteiligteAutoren);
		if (! this.bücher.contains(neuesBuch)) {
			this.collectionAdjuster.adjustInvolvedCollections(neuesBuch);
			return true;
		} else {
			return false;
		}
	}
	
	
	public void addAutorToBuch(Buch buch, Autor newAutor) {
		this.collectionAdjuster.adjustCollectionsEffectedByAutorAdding(buch, newAutor);
	}
	
	
	public Buch searchBuch(Buch searchedBuch) {
//		ArrayList<Buch> helpList = new ArrayList<>(bücher); 
//		helpList.sort(null);
//		return helpList.get(Collections.binarySearch(helpList, searchedBuch));
		for (Buch buch : this.bücher) {
			if (buch.equals(searchedBuch)) {
				return buch;
			}
		}
		return null;
	}

	
	public AutorenVerwalter getAutorenVerwalter() {
		return this.autorenVerwalter;
	}


	public void setAutorenVerwalter(AutorenVerwalter autorenVerwalter) {
		this.autorenVerwalter = autorenVerwalter;
	}


	public VerlagVerwalter getVerlagVerwalter() {
		return this.verlagVerwalter;
	}


	public void setVerlagVerwalter(VerlagVerwalter verlagVerwalter) {
		this.verlagVerwalter = verlagVerwalter;
	}


	public BuchTypVerwalter getBuchTypVerwalter() {
		return this.buchTypVerwalter;
	}


	public void setBuchTypVerwalter(BuchTypVerwalter buchTypVerwalter) {
		this.buchTypVerwalter = buchTypVerwalter;
	}


	public Collection<Buch> getBücher() {
		return this.bücher;
	}


	public void setBücher(Collection<Buch> bücher) {
		this.bücher = bücher;
	}


	public Collection<Autor> getAutoren() {
		return this.autoren;
	}


	public void setAutoren(Collection<Autor> autoren) {
		this.autoren = autoren;
	}


	public Collection<Verlag> getVerläge() {
		return this.verläge;
	}


	public void setVerläge(Collection<Verlag> verläge) {
		this.verläge = verläge;
	}


	public Collection<BuchTyp> getBuchTypen() {
		return this.buchTypen;
	}


	public void setBuchTypen(Collection<BuchTyp> buchTypen) {
		this.buchTypen = buchTypen;
	}
}
