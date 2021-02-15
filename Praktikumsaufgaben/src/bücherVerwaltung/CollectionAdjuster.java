package bücherVerwaltung;

import java.util.Collection;
import java.util.HashSet;

public class CollectionAdjuster {

	
	BücherVerwaltung bücherVerwaltung;
	
	
	public CollectionAdjuster(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	
	public void adjustInvolvedCollections(Buch buch) {
		bücherVerwaltung.getBücher().addAll(createHelpSet(buch, bücherVerwaltung.getBücher()));
		for (Autor autor : buch.getAutoren()) {
			autor.getBücher().addAll(createHelpSet(buch, autor.getBücher()));
		}
		for (Verlag verlag : buch.getVerläge()) {
			verlag.getBücher().addAll(createHelpSet(buch, verlag.getBücher()));
		}
//		
//		
//		Hier mit dem "adjusten" der Autoren und Verläge gegenseitig weitermachen und nicht dier Listen in der Verwaltung vergessen!
//		
//		
	}
	
	public Collection<Buch> createHelpSet(Buch inputBuch, Collection<Buch> inputList) {
		HashSet<Buch> helpSet = new HashSet<>();
		helpSet.addAll(inputList);
		helpSet.add(inputBuch);
		return helpSet;
	}
}
