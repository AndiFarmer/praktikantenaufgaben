package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Start {

	public static void main(String[] args) {
//		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
//		//myBücherVerwaltung.getVerläge().add(new Verlag("Scholastic Press", "New York"));
//		Verlag verlag1 = new Verlag("Scholastic Press", "New York");
//		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
//		Autor autor1 = new Autor("Suzanne", "Collins");
//		Buch buch1 = new Buch("The Hunger Games", "978-0-439-02352-8", 2008, verlag1, buchTyp1, autor1);
//		myBücherVerwaltung.getBücher().add(buch1);
//		
//		//System.out.println(myBücherVerwaltung.getAutoren().get(0).getVerläge().get(0).getName());
//		System.out.println(autor1.getVerläge().get(0).getName());
//		

		String string1 = new String("lol");
		String string2 = new String();
		System.out.println(string1.compareTo(string2));

		
		Collection<Autor> testList1 = new ArrayList<>();
		Collection<Autor> testList2 = new ArrayList<>();
		for(int i = 0; i<10; i++) {
			testList1.add(new Autor(String.valueOf(i) , "Peter"));
		}
		for(int i = 0; i<5; i++) {
			testList2.add(new Autor(String.valueOf(i+1) , "Peter"));
		}
		
		Iterator<Autor> it1 = testList1.iterator();
		Iterator<Autor> it2 = testList2.iterator();
		Autor autor1;
		Autor autor2;
		Collection<Integer> ergebnisse = new ArrayList<>();
		
		while (it1.hasNext() && it2.hasNext()) {
			autor1 = it1.next();
			autor2 = it2.next();
			ergebnisse.add(autor1.compareTo(autor2));
		}
		System.out.println(ergebnisse);
		// return it1.hasNext() ? 1 : -1;
	}

}
