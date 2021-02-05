package bücherVerwaltung;

public class Start {

	public static void main(String[] args) {
//		Buch buch1 = new Buch();
//		Autor autor = new Autor();
//		autor.addBuch(buch1);
//		autor.addBuch(buch1);
//		Buch buch2 = new Buch();
//		autor.addBuch(buch2);
		
//		String a = new String("test");
//		String b = new String("test");
//		if (a == b) System.out.println(true);
//		
	
		BücherVerwaltung myBücherVerwaltung = new BücherVerwaltung();
		myBücherVerwaltung.getAutorenVerwalter().createAutor("Ursula", "Poznanski", myBücherVerwaltung);
		Autor gesuchterAutor = myBücherVerwaltung.getAutorenVerwalter().searchAutor("Ursula", "Poznanski", myBücherVerwaltung);
		
		if(gesuchterAutor != null) {
			System.out.println(gesuchterAutor.getNachName());
		} else {
			System.out.println("nicht gefunden");
		}
	}

}
