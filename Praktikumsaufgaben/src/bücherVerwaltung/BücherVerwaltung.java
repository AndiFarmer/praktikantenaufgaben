package bücherVerwaltung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class BücherVerwaltung implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151384285086266694L;
	private transient AutorenVerwalter autorenVerwalter;
	private transient VerlagVerwalter verlagVerwalter;
	private transient BuchTypVerwalter buchTypVerwalter;
	
	private transient CollectionAdjuster collectionAdjuster;
	
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
	
	
	public void addAutorToBuch(Buch buch, Autor newAutor, boolean autorSchonvorhanden) {
		this.collectionAdjuster.adjustCollectionsEffectedByAutorAdding(buch, newAutor, autorSchonvorhanden);
	}
	
	
	public void addVerlagToBuch(Buch buch, Verlag newVerlag, boolean verlagSchonvorhanden) {
		this.collectionAdjuster.adjustCollectionsEffectedByVerlagAdding(buch, newVerlag, verlagSchonvorhanden);
	}
	
	
	public void removeAutorFromBuch(Buch buch, Autor autor) {
		this.collectionAdjuster.adjustCollectionsEffectedByAutorRemovalFromBuch(buch, autor);
	}
	
	
	public void removeVerlagFromBuch(Buch buch, Verlag verlag) {
		this.collectionAdjuster.adjustCollectionsEffectedByVerlagRemovalFromBuch(buch, verlag);
	}
	
	
	public void changeBuchTyp(Buch buch, BuchTyp newBuchTyp) {
		BuchTyp oldBuchTyp = buch.getBuchTyp();
		buch.setBuchTyp(newBuchTyp);
		this.collectionAdjuster.adjustCollectionsEffectedByBuchTypChange(newBuchTyp, oldBuchTyp);
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
