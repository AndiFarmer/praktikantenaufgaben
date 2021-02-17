package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collections;

public class AutorenVerwalter {
	
	
	BücherVerwaltung bücherVerwaltung;
	
	
	public AutorenVerwalter(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}


	public Autor searchAutor(Autor searchedAutor) {
		ArrayList<Autor> helpList = new ArrayList<>(bücherVerwaltung.getAutoren()); 
		helpList.sort(null);
		return helpList.get(Collections.binarySearch(helpList, searchedAutor));
	}
}
