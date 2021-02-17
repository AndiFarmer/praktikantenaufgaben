package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class CollectionAdjuster2 {

	
	BücherVerwaltung bücherVerwaltung;
	
	
	public CollectionAdjuster2(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	
	public void adjustInvolvedCollections(Buch buch) {
		bücherVerwaltung.setBücher(createBuchHelpSet(buch, bücherVerwaltung.getBücher()));
		bücherVerwaltung.getAutoren().addAll(createAutorHelpSet(buch, bücherVerwaltung.getAutoren()));
		bücherVerwaltung.getVerläge().addAll(createVerlagHelpSet(buch, bücherVerwaltung.getVerläge()));
		for (Autor autor : buch.getAutoren()) {
			autor.getBücher().addAll(createBuchHelpSet(buch, autor.getBücher()));
			autor.getVerläge().addAll(createVerlagHelpSet(buch, autor.getVerläge()));
		}
		for (Verlag verlag : buch.getVerläge()) {
			verlag.getBücher().addAll(createBuchHelpSet(buch, verlag.getBücher()));
			verlag.getAutoren().addAll(createAutorHelpSet(buch, verlag.getAutoren()));
		}
	}
	

	public Collection<Buch> createBuchHelpSet (Buch inputBuch, Collection<Buch> inputList) {
		HashSet<Buch> helpSet = new HashSet<>(inputList);
		helpSet.add(inputBuch);
		ArrayList<Buch> output = new ArrayList<>(helpSet);
//		Collections.sort(al);
//		int i = Collections.binarySearch(al, inputBuch);
//		System.out.println(i);
		return output;
	}
	
	
	public Collection<Autor> createAutorHelpSet (Buch inputBuch, Collection<Autor> inputList) {
		HashSet<Autor> helpSet = new HashSet<>();
		helpSet.addAll(inputList);
		helpSet.addAll(inputBuch.getAutoren());
		return helpSet;
	}
	
	
	public Collection<Verlag> createVerlagHelpSet (Buch inputBuch, Collection<Verlag> inputList) {
		HashSet<Verlag> helpSet = new HashSet<>();
		helpSet.addAll(inputList);
		helpSet.addAll(inputBuch.getVerläge());
		return helpSet;
	}
}
