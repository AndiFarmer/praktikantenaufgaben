package bücherVerwaltung;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Start {

	public static void main(String[] args) {
		
		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
		Collection<Verlag> verläge1 = new ArrayList<Verlag>();
		verläge1.add(new Verlag("Scholastic Press", "New York"));
		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
		Collection<Autor> autoren1 = new ArrayList<>();
		autoren1.add(new Autor("Suzanne", "Collins"));
		myBücherVerwaltung.addNewBuch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
		
		DateiArbeiter myArbeiter = new DateiArbeiter();
		myArbeiter.saveStatus(myBücherVerwaltung, new File ("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\Instanz"));
		myArbeiter.reconstructStatus(new File ("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\Instanz"));
//		long anfangsZeit = Start.getTime();
//		for (int i = 0; i < 15; i++) {
//			myBücherVerwaltung.addNewBuch(("The Hunger Games" + i), "978-0-439-02352-8", 2008, verläge1, new BuchTyp(""+ (-i%17)), autoren1);
//		}
//		System.out.println("Zeit: " + (Start.getTime() - anfangsZeit) + "ms");
//		
//		ArrayList<Buch> helpList = new ArrayList<>();
//		helpList.addAll(myBücherVerwaltung.getBücher());
//		System.out.println(helpList.get(9));
//		System.out.println(helpList.get(1).equals(helpList.get(0)));
//		
		
//		// Test des Veränderns eines Autors und ob dieser auch für alle verändert wurde
//		Iterator<Autor> it = helpList.get(9).getAutoren().iterator();
//		if (it.hasNext()) {
//			it.next().setNachName("testNachName");
//		}
//		
//		// Test des Veränderns eines Verlags und ob dieser auch für alle verändert wurde
//		Iterator<Verlag> it2 = helpList.get(9).getVerläge().iterator();
//		if (it2.hasNext()) {
//			it2.next().setName("testName");
//		}
//		System.out.println();
//		System.out.println("Teständern von Autor und Verlag");
//		System.out.println(helpList.get(10));
//		System.out.println(helpList.get(9));
//		
//		// Test des Addens von Autor und Verlag zum Buch
//		myBücherVerwaltung.addAutorToBuch(helpList.get(9), new Autor("Florian", "Bertold"), false);
//		myBücherVerwaltung.addVerlagToBuch(helpList.get(9), new Verlag("Bertolds Beste", "Rheinbach"), false);
//		System.out.println();
//		System.out.println("Testadden von Autor und Verlag");
//		System.out.println(helpList.get(9));
//		System.out.println(helpList.get(9).getAutoren());
//		System.out.println(helpList.get(9).getVerläge());
//		System.out.println(myBücherVerwaltung.getAutoren());
//		System.out.println(myBücherVerwaltung.getVerläge());
//		
//		// Test des Löschens von Autor und Verlag von Buch
//		myBücherVerwaltung.removeAutorFromBuch(helpList.get(9), new Autor("Florian", "Bertold"));
//		myBücherVerwaltung.removeVerlagFromBuch(helpList.get(9), new Verlag("Bertolds Beste", "Rheinbach"));
//		System.out.println();
//		System.out.println("Testlöschen von Autor und Verlag");
//		System.out.println(helpList.get(9));
//		System.out.println(helpList.get(9).getAutoren());
//		System.out.println(helpList.get(9).getVerläge());
//		System.out.println(myBücherVerwaltung.getAutoren());
//		System.out.println(myBücherVerwaltung.getVerläge());
//		
//		// Test des Änderns vom Buchtyp
//		System.out.println();
//		System.out.println(helpList.get(9).getBuchTyp());
//		System.out.println(myBücherVerwaltung.getBuchTypen());
//		myBücherVerwaltung.changeBuchTyp(helpList.get(9), new BuchTyp("online"));
//		System.out.println(helpList.get(9).getBuchTyp());
//		System.out.println(myBücherVerwaltung.getBuchTypen());
	}
	
	
	
	
		
	public static long getTime() {
		return System.currentTimeMillis();
	}
}
