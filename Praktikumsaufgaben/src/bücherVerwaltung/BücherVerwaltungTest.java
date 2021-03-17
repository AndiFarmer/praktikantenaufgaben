package bücherVerwaltung;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BücherVerwaltungTest {

	@Test
	void addNewBuchTest() {
		int anzahlBücher = 3;
		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
		Buch[] buchArr = this.initBuchArr(anzahlBücher);
		buchArr[0].setAutoren(buchArr[2].getAutoren()); /* Um zu testen, ob die Autoren nach dem Hinzufügen der Bücher 
		zur BücherVerwaltung auch beide Bücher beinhalten und die Verläge der Autoren auch mit den Verlägen der beiden Bücher übereinstimmen */
		
		for (Buch buch : buchArr) {
			myBücherVerwaltung.addNewBuch(buch);
		}
		// ! hiernach sind die gleichen Bücher(und damit ihre Attribute) angepasst, wie im buchArr, weil es sich um ein und die selben Referenzen handelt
		
		Set<Autor> allAutoren = new LinkedHashSet<>(); // Linked Hashset, damit Reihenfolge beibehalten und keine Dopplungen von Elementen
		Set<Verlag> allVerläge = new LinkedHashSet<>(); // '-> Das ist nötig damit die Listen erstellt werden könnnen, 
		Set<BuchTyp> allBuchTypen = new LinkedHashSet<>(); // wie sie in BücherVerwaltung vorliegen sollten
		for (int i = 0; i < anzahlBücher; i++) { // Befüllen der Sets mit den Attributen der Bücher, 
			// um die "Listen" (LinkedHashSets) zu erstellen, die in BücherVerwalung sein sollten
			allAutoren.addAll(buchArr[i].getAutoren());
			allVerläge.addAll(buchArr[i].getVerläge());
			allBuchTypen.add(buchArr[i].getBuchTyp());
		}
		ArrayList<Autor> allAutorenCorrect = new ArrayList<>();
		ArrayList<Verlag> allVerlägeCorrect = new ArrayList<>();
		ArrayList<BuchTyp> allBuchTypenCorrect = new ArrayList<>();
		allAutorenCorrect.addAll(allAutoren);
		allVerlägeCorrect.addAll(allVerläge);
		allBuchTypenCorrect.addAll(allBuchTypen);
		
		Iterator<Buch> buchIterVerwaltung = myBücherVerwaltung.getBücher().iterator();
		for (int i = 0; i < buchArr.length; i++) {
			Assertions.assertEquals(buchIterVerwaltung.next(), buchArr[i]);
		}
		Assertions.assertEquals(allAutorenCorrect, myBücherVerwaltung.getAutoren());
		Assertions.assertEquals(allVerlägeCorrect, myBücherVerwaltung.getVerläge());
		Assertions.assertEquals(allBuchTypenCorrect, myBücherVerwaltung.getBuchTypen());
		
		ArrayList<Verlag> correctVerlägeOfFirstAutorOfFirstBuch = new ArrayList<Verlag>();
		correctVerlägeOfFirstAutorOfFirstBuch.add(new Verlag("Name0", "Ort0"));
		correctVerlägeOfFirstAutorOfFirstBuch.add(new Verlag("Name2", "Ort2"));
		Assertions.assertEquals(correctVerlägeOfFirstAutorOfFirstBuch, 
				myBücherVerwaltung.getBücher().iterator().next().getAutoren().iterator().next().getVerläge()); // Test, ob die Verlagsliste 
		// in dem Autor im ersten Buch korrekt hinterlegt ist
	}
	
	@Test
	void saveTest() {
		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
		File file = new File("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\BücherVerwaltungTest\\saveTest\\1.xml");
		Buch[] buchArr = this.initBuchArr(3);
		buchArr[0].setAutoren(buchArr[2].getAutoren()); // Um zu testen, ob nachher noch die Referenzen auf alle Autoren da sind
		for (Buch buch : buchArr) {
			myBücherVerwaltung.addNewBuch(buch);
		}
		try {
			myBücherVerwaltung.save(file);
		} catch (BücherVerwaltungException e) {
			e.printStackTrace();
		}
		BücherVerwaltung myBücherVerwaltung2 = new BücherVerwaltung();
		myBücherVerwaltung2 = myBücherVerwaltung2.load(file);
		Assertions.assertEquals(myBücherVerwaltung.getBücher(), myBücherVerwaltung2.getBücher());
		Assertions.assertEquals(myBücherVerwaltung.getAutoren(), myBücherVerwaltung2.getAutoren());
		Assertions.assertEquals(myBücherVerwaltung.getVerläge(), myBücherVerwaltung2.getVerläge());
		Assertions.assertEquals(myBücherVerwaltung.getBuchTypen(), myBücherVerwaltung2.getBuchTypen());
		Assertions.assertEquals(myBücherVerwaltung.getAutoren().iterator().next().getVerläge(),
				myBücherVerwaltung2.getAutoren().iterator().next().getVerläge());
	}
	
	private Buch[] initBuchArr(int anzahl) {
		Buch[] output = new Buch[anzahl];
		ArrayList<Verlag>[] verlägeArr = new ArrayList[anzahl]; // Array von ArrayList<Verlag> nötig damit in der Schleife
		// ArrayLists im Konstruktor des Buches stehen
		ArrayList<Autor>[] autorenArr = new ArrayList[anzahl];
		for (int i = 0; i < anzahl; i++) {
			verlägeArr[i] = new ArrayList<Verlag>();
			verlägeArr[i].add(new Verlag("Name" + i, "Ort" + i));
			autorenArr[i] = new ArrayList<Autor>();
			autorenArr[i].add(new Autor("VorName" + i, "NachName" + i));
			output[i] = new Buch("Titel" + i, "ISBN" + i, i, verlägeArr[i], new BuchTyp("BuchTyp" + i), autorenArr[i]);
		}
		System.out.println("output[0].getAutoren().iterator().next().getBücher; ->" + output[0].getAutoren().iterator().next().getBücher()); // WIESO DRUCKT DAS 2MAL!!!???
		return output;	
	}

}
