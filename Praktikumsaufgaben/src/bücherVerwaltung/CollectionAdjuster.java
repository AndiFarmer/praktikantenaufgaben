package bücherVerwaltung;

public class CollectionAdjuster {

	
	BücherVerwaltung bücherVerwaltung;
	
	
	public CollectionAdjuster(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	
	// falls der Benutzer später aus vorhandenen Listen Autoren auswählt dann sind einige add-Funktionen und Referenzanpassungen unnötig
	public boolean adjustInvolvedCollections(Buch buch) {
		this.bücherVerwaltung.getBücher().add(buch); 
		this.adjustBuchTypenCollections(buch); 
		this.adjustCollectionsRest(buch); 
		return true;
	}


	private void adjustCollectionsRest(Buch buch) {
		for (Autor buchAutor : buch.getAutoren()) {
			if (! this.bücherVerwaltung.getAutoren().contains(buchAutor)) {
				this.bücherVerwaltung.getAutoren().add(buchAutor);
			}
			for (Verlag buchVerlag : buch.getVerläge()) {
				if (! this.bücherVerwaltung.getVerläge().contains(buchVerlag)) {
					this.bücherVerwaltung.getVerläge().add(buchVerlag);
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
		if (! this.bücherVerwaltung.getBuchTypen().contains(buch.getBuchTyp())) {
			this.bücherVerwaltung.getBuchTypen().add(buch.getBuchTyp());
		} 
	}


	public void adjustCollectionsEffectedByAutorAdding(Buch buch, Autor newAutor, boolean autorSchonVorhanden) { 
		// es wird davon ausgegangen, dass buch schon vorher vorhanden ist 
		// Außerdem sollte vorher schon sichergestellt sein, dass kein bereits vorhandener Autor (im Buch) geaddet wird -> dem Benutzer 
		// werden diese nicht zu Auswahl gestellt; sollte er sie manuell eingeben wird eine Warnung ausgegeben
		if (! autorSchonVorhanden) {
			this.bücherVerwaltung.getAutoren().add(newAutor);
			buch.getAutoren().add(newAutor);
			for (Verlag verlag : buch.getVerläge()) {
					verlag.getAutoren().add(newAutor);
			}
		} else if (! buch.getAutoren().contains(newAutor)){
			buch.getAutoren().add(newAutor);
			for (Verlag verlag : buch.getVerläge()) {
				if (! verlag.getAutoren().contains(newAutor)) {
					verlag.getAutoren().add(newAutor);
				}
			}
		} else {
			return;
		}
	}
	
	public void adjustCollectionsEffectedByVerlagAdding(Buch buch, Verlag newVerlag, boolean verlagSchonVorhanden) { 
		// es wird davon ausgegangen, dass buch schon vorher vorhanden ist 
		// Außerdem sollte vorher schon sichergestellt sein, dass kein bereits vorhandener Autor (im Buch) geaddet wird -> dem Benutzer 
		// werden diese nicht zu Auswahl gestellt; sollte er sie manuell eingeben wird eine Warnung ausgegeben
		if (! verlagSchonVorhanden) {
			this.bücherVerwaltung.getVerläge().add(newVerlag);
			buch.getVerläge().add(newVerlag);
			for (Autor autor : buch.getAutoren()) {
					autor.getVerläge().add(newVerlag);
			}
		} else if (! buch.getVerläge().contains(newVerlag)){
			buch.getVerläge().add(newVerlag);
			for (Autor autor : buch.getAutoren()) {
				if (! autor.getVerläge().contains(newVerlag)) {
					autor.getVerläge().add(newVerlag);
				}
			}
		} else {
			return;
		}
	}
}
