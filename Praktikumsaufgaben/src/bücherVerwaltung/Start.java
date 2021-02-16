package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Start {

	public static void main(String[] args) {
		
		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
		Collection<Verlag> verläge1 = new ArrayList<Verlag>();
		verläge1.add(new Verlag("Scholastic Press", "New York"));
		verläge1.add(new Verlag("Verlag", "Ort"));
		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
		Collection<Autor> autoren1 = new ArrayList<>();
		autoren1.add(new Autor("Suzanne", "Collins"));
		autoren1.add(new Autor("Vorname", "Nachname"));
		myBücherVerwaltung.addNewBuch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
		long anfangsZeit = getTime();
		for (int i = 0; i < 10; i++) {
			myBücherVerwaltung.addNewBuch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
		}
		//myBücherVerwaltung.searchBuch(new Buch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1));
		System.out.println("Zeit: " + (getTime() - anfangsZeit) + "ms");
		ArrayList<Buch> helpList = new ArrayList<>();
		helpList.addAll(myBücherVerwaltung.getBücher());
		System.out.println(helpList.get(9));
		System.out.println(helpList.get(0).equals(helpList.get(1)));
	}
	
	
	public static long getTime() {
		return System.currentTimeMillis();
	}

}
