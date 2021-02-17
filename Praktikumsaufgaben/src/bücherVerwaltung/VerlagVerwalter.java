package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collections;

public class VerlagVerwalter {

	private BücherVerwaltung bücherVerwaltung;

	public VerlagVerwalter(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	public Verlag searchVerlag(Verlag searchedVerlag) {
		ArrayList<Verlag> helpList = new ArrayList<>(bücherVerwaltung.getVerläge()); 
		helpList.sort(null);
		return helpList.get(Collections.binarySearch(helpList, searchedVerlag));
	}
}
