package bücherVerwaltung;

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
		
	}

}
