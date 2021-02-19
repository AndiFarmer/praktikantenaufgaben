package bücherVerwaltung;

public class CollectionAdjusterContainWithReferenzAnpassung {

	
	BücherVerwaltung bücherVerwaltung;
	
	
	public CollectionAdjusterContainWithReferenzAnpassung(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	// falls der Benutzer später aus vorhandenen Listen Autoren auswählt dann sind einige add-Funktionen und Referenzanpassungen unnötig
	public boolean adjustInvolvedCollections(Buch buch) {
		bücherVerwaltung.getBücher().add(buch); // durch die Kontrolle in der BücherVerwaltung kann ich mir sicher sein, dass buch durch diese Zeile nicht doppelt vorkommt
		adjustBuchTypenCollections(buch); // inkl. ggf. Referenzenanpassung im Buch
		adjustCollectionsRest(buch); // inkl. ggf. Referenzanpassungen im Buch
		return true;
	}


	private void adjustCollectionsRest(Buch buch) {
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
	}

	private void adjustBuchTypenCollections(Buch buch) {
		if (! bücherVerwaltung.getBuchTypen().contains(buch.getBuchTyp())) {
			bücherVerwaltung.getBuchTypen().add(buch.getBuchTyp());
		} 
		else {
			buch.setBuchTyp(bücherVerwaltung.getBuchTypVerwalter().searchBuchTyp(buch.getBuchTyp())); // Referenzenanpassung
		}
	}

	
	public void adjustCollectionsEffectedByAutorAdding(Buch buch, Autor newAutor) {
		
	}
}
