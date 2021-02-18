package bücherVerwaltung;

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
		verläge1.add(new Verlag("Verlag", "Ort"));
		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
		Collection<Autor> autoren1 = new ArrayList<>();
		autoren1.add(new Autor("Suzanne", "Collins"));
		autoren1.add(new Autor("Vorname", "Nachname"));
		myBücherVerwaltung.addNewBuch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
		
		long anfangsZeit = Start.getTime();
		for (int i = 0; i < 10000; i++) {
			myBücherVerwaltung.addNewBuch(("The Hunger Games" + i), "978-0-439-02352-8", 2008, verläge1, new BuchTyp(""+ (-i%17)), autoren1);
		}
		System.out.println("Zeit: " + (Start.getTime() - anfangsZeit) + "ms");
		
		ArrayList<Buch> helpList = new ArrayList<>();
		helpList.addAll(myBücherVerwaltung.getBücher());
		System.out.println(helpList.get(9));
		System.out.println(helpList.get(1).equals(helpList.get(0)));
		Iterator<Autor> it = helpList.get(9).getAutoren().iterator();
		if (it.hasNext()) {
			it.next().setNachName("testNachName");
		}
		Iterator<Verlag> it2 = helpList.get(9).getVerläge().iterator();
		if (it2.hasNext()) {
			it2.next().setName("testName");
		}
		System.out.println(helpList.get(10));
		System.out.println(helpList.get(9));
//		Integer i = new Integer(8);
//		Integer j = i;
//		j += 1;
//		System.out.println(i);
//		Verlag verlag = new Verlag("test", "test");
//		Verlag verlag2 = verlag;
//		verlag.setOrt("Test");
//		System.out.println(verlag2.getOrt());
	}
	
		
	public static long getTime() {
		return System.currentTimeMillis();
	}

}
