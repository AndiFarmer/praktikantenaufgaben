package bücherverwaltung;

public class AutorenVerwalter {
	
	public AutorenVerwalter() {
		
	}

	public Autor searchAutor(String vorname, String nachname, BücherVerwaltung myBücherVerwaltung) {
		Autor searchedAutor = new Autor(vorname, nachname);

		for(int i = 0; i < myBücherVerwaltung.getAutoren().size(); i++) {
			if(searchedAutor.equals(myBücherVerwaltung.getAutoren().get(i))) {
				return myBücherVerwaltung.getAutoren().get(i);
			}
		}
		return null;
	}	
	
}
