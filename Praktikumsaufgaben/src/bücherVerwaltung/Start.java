package bücherVerwaltung;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Start {

	public static void main(String[] args) {
		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
		//myBücherVerwaltung.getVerläge().add(new Verlag("Scholastic Press", "New York"));
		Verlag verlag1 = new Verlag("Scholastic Press", "New York");
		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
		Autor autor1 = new Autor("Suzanne", "Collins");
		Buch buch1 = new Buch("The Hunger Games", "978-0-439-02352-8", 2008, verlag1, buchTyp1, autor1);
		myBücherVerwaltung.getBücher().add(buch1);
		
		//System.out.println(myBücherVerwaltung.getAutoren().get(0).getVerläge().get(0).getName());
		System.out.println(autor1.getVerläge().get(0).getName());
		
		
		List<BuchTyp> testList = new ArrayList<>(); 
		testList.add(new BuchTyp("a"));
		testList.add(new BuchTyp("b"));
		testList.add(new BuchTyp("c"));
		testList.add(new BuchTyp("d"));
		System.out.println(testList.toString());
		testList.sort(null);
		System.out.println(testList.toString());
		System.out.println(testList.contains(new BuchTyp("a")));
		
		List<BuchTyp> testList2 = new ArrayList<>(); 
		testList2.add(new BuchTyp("a"));
		testList2.add(new BuchTyp("b"));
		testList2.add(new BuchTyp("c"));
		testList2.add(new BuchTyp("d"));
		Iterator<BuchTyp> myIterator = testList2.iterator();
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next().getBezeichnung());
		}
		testList2.sort(null);
		Iterator<BuchTyp> myIterator2 = testList2.iterator();
		while (myIterator2.hasNext()) {
			System.out.println(myIterator2.next().getBezeichnung());
		}
		
		Map<String, Integer> myLinkedHashMap = new LinkedHashMap<>();
		myLinkedHashMap.put("a", 11);
		myLinkedHashMap.put("d", 7);
		myLinkedHashMap.put("c", 31);
		System.out.println(myLinkedHashMap.containsKey("b"));
		System.out.println(myLinkedHashMap + "\n" + myLinkedHashMap.entrySet());
//		System.out.println(myLinkedHashMap.entrySet().iterator().next().remove());
		System.out.println(myLinkedHashMap);
		
		int gesamt = 0;
		for (Iterator<Map.Entry<String, Integer>> it = myLinkedHashMap.entrySet().iterator(); it.hasNext(); ) {
			gesamt += it.next().getValue();
		}
		System.out.println(gesamt);
		
		Set<String> test = new HashSet<String>();
	}

}
