package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class CollectionAdjusterHash {

	
	BücherVerwaltung bücherVerwaltung;
	
	
	public CollectionAdjusterHash(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	
	public void adjustInvolvedCollections(Buch buch) {
		bücherVerwaltung.getBücher().add(buch); // durch die Kontrolle in der BücherVerwaltung kann ich mir sicher sein, dass buch durch diese Zeile nicht doppelt vorkommt
		bücherVerwaltung.setAutoren(createAutorHelpSetAndAdjustReferncesOfBuch(buch, bücherVerwaltung.getAutoren()));
		bücherVerwaltung.setVerläge(createVerlagHelpSetAndAdjustReferncesOfBuch(buch, bücherVerwaltung.getVerläge()));
		bücherVerwaltung.setBuchTypen(createBuchTypHelpSetAndAdjustReferencesOfBuch(buch, bücherVerwaltung.getBuchTypen()));
		for (Autor autor : buch.getAutoren()) {
			autor.setBücher(createBuchHelpSet(buch, autor.getBücher()));
			autor.setVerläge(createVerlagHelpSet(buch, autor.getVerläge()));
		}
		for (Verlag verlag : buch.getVerläge()) {
			verlag.setBücher(createBuchHelpSet(buch, verlag.getBücher()));
			verlag.setAutoren(createAutorHelpSet(buch, verlag.getAutoren()));
		}
	}


	public Collection<Buch> createBuchHelpSet(Buch inputBuch, Collection<Buch> inputList) {
		HashSet<Buch> helpSet = new HashSet<>(inputList);
		helpSet.add(inputBuch);
		ArrayList<Buch> output = new ArrayList<>(helpSet);
		return output;
	}
	
	
	public Collection<Autor> createAutorHelpSet(Buch inputBuch, Collection<Autor> inputList) {
		HashSet<Autor> helpSet = new HashSet<>(inputList);
		helpSet.addAll(inputBuch.getAutoren());
		ArrayList<Autor> output = new ArrayList<>(helpSet);
		return output;
	}
	
	
	public Collection<Autor> createAutorHelpSetAndAdjustReferncesOfBuch(Buch inputBuch, Collection<Autor> inputList) {
		HashSet<Autor> helpSet = new HashSet<>(inputList);
		for (Autor autor : inputBuch.getAutoren()) {
			if (! helpSet.add(autor)) {
				autor = bücherVerwaltung.getAutorenVerwalter().searchAutor(autor);
			}
		}
		ArrayList<Autor> output = new ArrayList<>(helpSet);
		return output;
	}
	
	
	public Collection<Verlag> createVerlagHelpSet(Buch inputBuch, Collection<Verlag> inputList) {
		HashSet<Verlag> helpSet = new HashSet<>(inputList);
		helpSet.addAll(inputBuch.getVerläge());
		ArrayList<Verlag> output = new ArrayList<>(helpSet);
		return output;
	}
	
	
	private Collection<Verlag> createVerlagHelpSetAndAdjustReferncesOfBuch(Buch inputBuch, Collection<Verlag> inputList) {
		HashSet<Verlag> helpSet = new HashSet<>(inputList);
		for (Verlag verlag : inputBuch.getVerläge()) {
			if (! helpSet.add(verlag)) {
				verlag = bücherVerwaltung.getVerlagVerwalter().searchVerlag(verlag);
			}
		}
		ArrayList<Verlag> output = new ArrayList<>(helpSet);
		return output;
	}
	
	
	private Collection<BuchTyp> createBuchTypHelpSetAndAdjustReferencesOfBuch(Buch inputBuch, Collection<BuchTyp> inputList) {
		HashSet<BuchTyp> helpSet = new HashSet<>(inputList);
		if (! helpSet.add(inputBuch.getBuchTyp())) {
			inputBuch.setBuchTyp(bücherVerwaltung.getBuchTypVerwalter().searchBuchTyp(inputBuch.getBuchTyp())); 
		}
		ArrayList<BuchTyp> output = new ArrayList<>(helpSet);
		return output;
	}
}
