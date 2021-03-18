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
		FensterVerwalter myFensterVerwalter = new FensterVerwalter();
		myFensterVerwalter.initStandardView();
		
		
		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
		Collection<Verlag> verläge1 = new ArrayList<Verlag>();
		verläge1.add(new Verlag("Scholastic Press", "New York"));
		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
		Collection<Autor> autoren1 = new ArrayList<>();
		autoren1.add(new Autor("Suzanne", "Collins"));
		Buch buch = new Buch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
		myBücherVerwaltung.addNewBuch(buch);
		Collection<Verlag> verläge2 = new ArrayList<>();
		verläge2.add(new Verlag("Verlagname", "Verlagort"));
		BuchTyp buchTyp2 = new BuchTyp("Online");
		Collection<Autor> autoren2 = new ArrayList<>();
		autoren2.add(new Autor("Vorname2", "Nachname2"));
		Buch buch2 = new Buch("Buch Zwei", "DiesIstISBN", 2021, verläge1, buchTyp2, autoren2);
		myBücherVerwaltung.addNewBuch(buch2);
		
		int anzahlNeuerBücher = 0000;
		long anfangsZeit = Start.getTime();
		for (int i = 0; i < anzahlNeuerBücher; i++) {
			myBücherVerwaltung.addNewBuch(new Buch(("The Hunger Games" + i), "978-0-439-02352-8", 2008, verläge1, new BuchTyp(""+ (-i%17)), autoren1));
		}
		System.out.println("Zeit Adden von "+ anzahlNeuerBücher + " Büchern: " + (Start.getTime() - anfangsZeit) + "ms");
		
//		ArrayList<Buch> helpList = new ArrayList<>();
//		helpList.addAll(myBücherVerwaltung.getBücher());
//		System.out.println(helpList.get(9));
//		System.out.println(helpList.get(1).equals(helpList.get(0)));
		
//		
//		// Test des Speicherns und Ladens der Bücher, Autoren, Verläge und BuchTypen
//		File fileSpeichernBücher2 = new File("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\Bücher2.ser");
//		File fileSpeichernAutoren = new File("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\Autoren.ser");
//		File fileSpeichernVerläge = new File("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\Verläge.ser");
//		File fileSpeichernBuchTypen = new File("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\BuchTypen.ser");
//		anfangsZeit = Start.getTime();
//		try {
//			myBücherVerwaltung.saveBücherAutorenVerlägeBuchTypen(fileSpeichernBücher2, fileSpeichernAutoren, 
//					fileSpeichernVerläge, fileSpeichernBuchTypen);
//		} catch (BücherVerwaltungException e1) {
//			e1.printStackTrace();
//		}
//		System.out.println("\nZeit Speichern Bücher, Autoren, Verläge und BuchTypen: " + (Start.getTime() - anfangsZeit) + "ms");
//		myBücherVerwaltung = new BücherVerwaltung();
//		anfangsZeit = Start.getTime();
//		myBücherVerwaltung.loadBücherAutorenVerlägeBuchTypen(fileSpeichernBücher2, fileSpeichernAutoren, 
//				fileSpeichernVerläge, fileSpeichernBuchTypen);
//		System.out.println("Zeit Laden Bücher, Autoren, Verläge und BuchTypen: " + (Start.getTime() - anfangsZeit) + "ms");
//		float BücherLength = fileSpeichernBücher2.length();
//		float AutorenLength = fileSpeichernAutoren.length();
//		float VerlägeLength = fileSpeichernVerläge.length();
//		float BuchTypenLength = fileSpeichernBuchTypen.length();
//		System.out.println("Länge der Dateien:\n-Bücher: " + BücherLength / 1024 + "KB\n-Autoren: " 
//		+ AutorenLength / 1024 + "KB\n-Verläge: " + VerlägeLength / 1024 + "KB\n-BuchTypen: " +
//		BuchTypenLength / 1024 + "KB\nGesamt: " + (BücherLength + AutorenLength + VerlägeLength + BuchTypenLength) / 1024 + "KB");
//		
//		
//		// Test des Speicherns und Ladens der Bücher direkt
//		File fileSpeichernBücher = new File("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\Bücher.ser");
//		anfangsZeit = Start.getTime();
//		try {
//			myBücherVerwaltung.saveBücher(fileSpeichernBücher);
//		} catch (BücherVerwaltungException e) {
//			e.printStackTrace();
//		}
//		System.out.println("\nZeit Speichern Bücher: " + (Start.getTime() - anfangsZeit) + "ms");
//		myBücherVerwaltung = new BücherVerwaltung();
////		System.out.println(myBücherVerwaltung.getBücher());
////		System.out.println(myBücherVerwaltung.getAutoren());
//		anfangsZeit = Start.getTime();
//		myBücherVerwaltung.loadBücher(fileSpeichernBücher);
//		System.out.println("Zeit Laden Bücher: " + (Start.getTime() - anfangsZeit) + "ms");
//		System.out.println("Länge der Datei: " + fileSpeichernBücher.length() / 1024 + "KB");
////		System.out.println(myBücherVerwaltung.getBücher());
////		System.out.println(myBücherVerwaltung.getAutoren());	
//		
//		
		// Test des Speicherns und Ladens der Bücherverwaltung
		File fileSpeichernBücherVerwaltung = new File("C:\\Users\\z1300a2k\\Documents\\Bücherverwaltung\\myBücherVerwaltung.xml");
		anfangsZeit = Start.getTime();
		try {
			myBücherVerwaltung.save(fileSpeichernBücherVerwaltung);
//			myBücherVerwaltung.save2(fileSpeichernBücherVerwaltung);
		} catch (BücherVerwaltungException e) {
			e.printStackTrace();
		}
		System.out.println("\nZeit Speichern BücherVerwaltung: " + (Start.getTime() - anfangsZeit) + "ms");
		myBücherVerwaltung = new BücherVerwaltung(); // Auf "Null" setzen -> Alle Listen leer
//		System.out.println(myBücherVerwaltung.getBücher());
//		System.out.println(myBücherVerwaltung.getAutoren());
//		System.out.println(myBücherVerwaltung.getVerläge());
//		System.out.println(myBücherVerwaltung.getBuchTypen());
		anfangsZeit = Start.getTime();
		myBücherVerwaltung = myBücherVerwaltung.load(fileSpeichernBücherVerwaltung);
		System.out.println("Zeit Laden BücherVerwaltung: " + (Start.getTime() - anfangsZeit) + "ms");
		System.out.println("Länge der Datei: " + fileSpeichernBücherVerwaltung.length() / 1024 + "KB");
//		System.out.println(myBücherVerwaltung.getBücher());
//		System.out.println(myBücherVerwaltung.getAutoren());
//		System.out.println(myBücherVerwaltung.getVerläge());
//		System.out.println(myBücherVerwaltung.getBuchTypen());
//		System.out.println(myBücherVerwaltung.getAutoren().iterator().next().getBücher());
//		System.out.println(myBücherVerwaltung.getAutoren().iterator().next().getVerläge());
//		System.out.println(myBücherVerwaltung.getVerläge().iterator().next().getBücher());
//		System.out.println(myBücherVerwaltung.getVerläge().iterator().next().getAutoren());
//		System.out.println(myBücherVerwaltung.getBücher().iterator().next().getBuchTyp());
//		System.out.println(myBücherVerwaltung.getBücher().iterator().next().getVerläge());
//		System.out.println(myBücherVerwaltung.getBücher().iterator().next().getAutoren());
//		
//		
//		// Test des Löschens eines Buches und ob auch alles damit verbundene angepasst wurde (nicht sämtliche Test abgebildet)
//		System.out.println("Vor der Buchlöschung:");
//		System.out.println(myBücherVerwaltung.getBücher());
//		System.out.println(myBücherVerwaltung.getAutoren());
//		System.out.println(myBücherVerwaltung.getVerläge());
//		System.out.println(myBücherVerwaltung.getBuchTypen());
//		myBücherVerwaltung.deleteBuch(deletionBuch);
//		System.out.println("\nNach der Buchlöschung:");
//		System.out.println(myBücherVerwaltung.getBücher());
//		System.out.println(myBücherVerwaltung.getAutoren());
//		System.out.println(myBücherVerwaltung.getVerläge());
//		System.out.println(myBücherVerwaltung.getBuchTypen());
//		
//		
//		// Test des Veränderns eines Autors und ob dieser auch für alle verändert wurde
//		Iterator<Autor> it = helpList.get(9).getAutoren().iterator();
//		if (it.hasNext()) {
//			it.next().setNachName("testNachName");
//		}
//		
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
