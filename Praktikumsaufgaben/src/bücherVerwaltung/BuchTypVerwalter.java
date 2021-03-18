package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuchTypVerwalter {
	
	
	BücherVerwaltung bücherVerwaltung;
	
	
	public BuchTypVerwalter(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}
	
	
//	public BuchTyp searchBuchTyp(BuchTyp searchedBuchTyp) { 
//		for (BuchTyp buchTyp : bücherVerwaltung.getBuchTypen()) {
//			if (buchTyp.equals(searchedBuchTyp)) {
//				return buchTyp;
//			}
//		}
//		return null;
//	}
	
	
	public BuchTyp searchBuchTyp(BuchTyp searchedBuchTyp) { 
		ArrayList<BuchTyp> helpList = new ArrayList<>(this.bücherVerwaltung.getBuchTypen()); 
		helpList.sort(null);
		//Collections.sort(helpList); -> ist ein indirketer Aufruf der Zeile drüber
		return helpList.get(Collections.binarySearch(helpList, searchedBuchTyp));
	}

}
