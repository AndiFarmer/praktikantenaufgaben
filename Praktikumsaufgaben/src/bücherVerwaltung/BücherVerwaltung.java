package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

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
		autorenVerwalter = new AutorenVerwalter(this);
		verlagVerwalter = new VerlagVerwalter(this);
		buchTypVerwalter = new BuchTypVerwalter(this);
		collectionAdjuster = new CollectionAdjuster(this);
		bücher = new ArrayList<Buch>();
		autoren = new ArrayList<Autor>();
		verläge = new ArrayList<Verlag>();
		buchTypen = new ArrayList<BuchTyp>();
	}

	
	public void addNewBuch(String titel, String isbn, int erscheinungsJahr, Collection<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, Collection<Autor> beteiligteAutoren) {
		Buch neuesBuch = new Buch(titel, isbn, erscheinungsJahr, beteiligteVerläge, myBuchTyp, beteiligteAutoren);
		if (! bücher.contains(neuesBuch)) {
			collectionAdjuster.adjustInvolvedCollections(neuesBuch);
		}
	}
	
	
	public Buch searchBuch(Buch searchedBuch) {
		Iterator<Buch> buchIt = this.bücher.iterator();
		while (buchIt.hasNext()) {
			Buch tempBuch = buchIt.next();
			if(tempBuch.equals(searchedBuch)) {
				return searchedBuch;
			}
		}
		return null;
	}

	
	public AutorenVerwalter getAutorenVerwalter() {
		return autorenVerwalter;
	}


	public void setAutorenVerwalter(AutorenVerwalter autorenVerwalter) {
		this.autorenVerwalter = autorenVerwalter;
	}


	public VerlagVerwalter getVerlagVerwalter() {
		return verlagVerwalter;
	}


	public void setVerlagVerwalter(VerlagVerwalter verlagVerwalter) {
		this.verlagVerwalter = verlagVerwalter;
	}


	public BuchTypVerwalter getBuchTypVerwalter() {
		return buchTypVerwalter;
	}


	public void setBuchTypVerwalter(BuchTypVerwalter buchTypVerwalter) {
		this.buchTypVerwalter = buchTypVerwalter;
	}


	public CollectionAdjuster getCollectionAdjuster() {
		return collectionAdjuster;
	}


	public void setCollectionAdjuster(CollectionAdjuster collectionAdjuster) {
		this.collectionAdjuster = collectionAdjuster;
	}


	public Collection<Buch> getBücher() {
		return bücher;
	}


	public void setBücher(Collection<Buch> bücher) {
		this.bücher = bücher;
	}


	public Collection<Autor> getAutoren() {
		return autoren;
	}


	public void setAutoren(Collection<Autor> autoren) {
		this.autoren = autoren;
	}


	public Collection<Verlag> getVerläge() {
		return verläge;
	}


	public void setVerläge(Collection<Verlag> verläge) {
		this.verläge = verläge;
	}


	public Collection<BuchTyp> getBuchTypen() {
		return buchTypen;
	}


	public void setBuchTypen(Collection<BuchTyp> buchTypen) {
		this.buchTypen = buchTypen;
	}
}
