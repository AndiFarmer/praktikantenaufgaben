package bücherVerwaltung;

public class CollectionAdjuster {

	
	BücherVerwaltung bücherVerwaltung;
	
	
	public CollectionAdjuster(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	// falls der Benutzer später aus vorhandenen Listen Autoren auswählt dann sind einige add-Funktionen und Referenzanpassungen unnötig
	public boolean adjustInvolvedCollections(Buch buch) {
		if (! bücherVerwaltung.getBücher().contains(buch)) {
			bücherVerwaltung.getBücher().add(buch);
		} else {
			return false;
		}
		
		adjustBuchTypenCollections(buch); // inkl. ggf. Referenzenanpassung im Buch
		
		for (Autor buchAutor : buch.getAutoren()) {
			if (! bücherVerwaltung.getAutoren().contains(buchAutor)) {
				bücherVerwaltung.getAutoren().add(buchAutor);
			}
			else {
				buchAutor = bücherVerwaltung.getAutorenVerwalter().searchAutor(buchAutor); // Referenzenanpassung
			}
			for (Verlag buchVerlag : buch.getVerläge()) {
				if (! bücherVerwaltung.getVerläge().contains(buchVerlag)) {
					bücherVerwaltung.getVerläge().add(buchVerlag);
				} 
				else {
					buchVerlag = bücherVerwaltung.getVerlagVerwalter().searchVerlag(buchVerlag); // Referenzenanpassung
				}
				if (! buchVerlag.getAutoren().contains(buchAutor)) {
					buchVerlag.getAutoren().add(buchAutor);
				}
				if (! buchVerlag.getBücher().contains(buch)) {
					buchVerlag.getBücher().add(buch);
				}
				if (! buchAutor.getVerläge().contains(buchVerlag)) {
					buchAutor.getVerläge().add(buchVerlag);
				}
			}
			if (! buchAutor.getBücher().contains(buch)) {
				buchAutor.getBücher().add(buch);
			}
		}
		return true;
	}


	private void adjustBuchTypenCollections(Buch buch) {
		if (! bücherVerwaltung.getBuchTypen().contains(buch.getBuchTyp())) {
			bücherVerwaltung.getBuchTypen().add(buch.getBuchTyp());
		} 
		else {
			buch.setBuchTyp(bücherVerwaltung.getBuchTypVerwalter().searchBuchTyp(buch.getBuchTyp())); // Referenzenanpassung
		}
	}
}
