package bücherVerwaltung;

public class CollectionAdjuster {

	
	BücherVerwaltung bücherVerwaltung;
	
	
	public CollectionAdjuster(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	
	// falls der Benutzer später aus vorhandenen Listen Autoren auswählt dann sind einige add-Funktionen und Referenzanpassungen unnötig
	public void adjustInvolvedCollections(Buch buch) {
		this.bücherVerwaltung.getBücher().add(buch); 
		this.adjustBuchTypenCollections(buch); 
		this.adjustCollectionsRest(buch); 
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
		// (autorSchonVorhanden beschreibt lediglich, ob Autor schon in BücherVerwaltung bekannt)
		if (! autorSchonVorhanden) {
			this.bücherVerwaltung.getAutoren().add(newAutor);
			buch.getAutoren().add(newAutor);
			for (Verlag verlag : buch.getVerläge()) {
					verlag.getAutoren().add(newAutor);
			}
		} else if (! buch.getAutoren().contains(newAutor)){
			buch.getAutoren().add(newAutor);// es muss nicht geprüft werden, ob schon vorhanden, da diese Funktion nur aufgerufen wird, wenn ein dem Buch unbekannter Autor hinzugefügt wird
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
		// Außerdem sollte vorher schon sichergestellt sein, dass kein bereits vorhandener Verlag (im Buch) geaddet wird -> dem Benutzer 
		// werden diese nicht zu Auswahl gestellt; sollte er sie manuell eingeben wird eine Warnung ausgegeben
		// (verlagSchonVorhanden beschreibt lediglich, ob Verlag schon in BücherVerwaltung bekannt)
		if (! verlagSchonVorhanden) {
			this.bücherVerwaltung.getVerläge().add(newVerlag);
			buch.getVerläge().add(newVerlag);
			for (Autor autor : buch.getAutoren()) {
					autor.getVerläge().add(newVerlag);
			}
		} else if (! buch.getVerläge().contains(newVerlag)){ 
			buch.getVerläge().add(newVerlag); // es muss nicht geprüft werden, ob schon vorhanden, da diese Funktion nur aufgerufen wird, wenn ein dem Buch unbekannter Verlag hinzugefügt wird 
			for (Autor autor : buch.getAutoren()) {
				if (! autor.getVerläge().contains(newVerlag)) {
					autor.getVerläge().add(newVerlag);
				}
			}
		} else {
			return;
		}
	}


	public void adjustCollectionsEffectedByAutorRemovalFromBuch(Buch buch, Autor autorToBeRemoved) {
		buch.getAutoren().remove(autorToBeRemoved);
		if (this.isAutorInOtherBücherOfBücherVerwaltung(autorToBeRemoved)) {
			for (Verlag verlag : buch.getVerläge()) {
				if (! this.isAutorInOtherBücherOfVerlag(verlag, autorToBeRemoved)) {
					verlag.getAutoren().remove(autorToBeRemoved);
				}
			}
		}
		else {
			this.bücherVerwaltung.getAutoren().remove(autorToBeRemoved);
			for (Verlag verlag : buch.getVerläge()) {
				verlag.getAutoren().remove(autorToBeRemoved);
			}
		}
	}
	
	
	public void adjustCollectionsEffectedByVerlagRemovalFromBuch(Buch buch, Verlag verlagToBeRemoved) {
		buch.getVerläge().remove(verlagToBeRemoved);
		if (this.isVerlagInOtherBücherOfBücherVerwaltung(verlagToBeRemoved)) {
			for (Autor autor : buch.getAutoren()) {
				if (! this.isVerlagInOtherBücherOfAutor(autor, verlagToBeRemoved)) {
					autor.getVerläge().remove(verlagToBeRemoved);
				}
			}
		}
		else {
			this.bücherVerwaltung.getVerläge().remove(verlagToBeRemoved);
			for (Autor autor : buch.getAutoren()) {
				autor.getVerläge().remove(verlagToBeRemoved);
			}
		}
	}
	
	
	public void adjustCollectionsEffectedByBuchTypChange(BuchTyp newBuchTyp, BuchTyp oldBuchTyp) {
		if (! this.isBuchTypInOtherBücherOfBücherVerwaltung(oldBuchTyp)) {
			this.bücherVerwaltung.getBuchTypen().remove(oldBuchTyp);
		}
		if (! this.bücherVerwaltung.getBuchTypen().contains(newBuchTyp)) {
			this.bücherVerwaltung.getBuchTypen().add(newBuchTyp);
		}
	}
	
	
	public boolean isAutorInOtherBücherOfBücherVerwaltung(Autor autor) {
		for (Buch bücherVerwaltungBuch : this.bücherVerwaltung.getBücher()) {
			if (bücherVerwaltungBuch.getAutoren().contains(autor)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isVerlagInOtherBücherOfBücherVerwaltung(Verlag verlag) {
		for (Buch bücherVerwaltungBuch : this.bücherVerwaltung.getBücher()) {
			if (bücherVerwaltungBuch.getVerläge().contains(verlag)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isAutorInOtherBücherOfVerlag(Verlag verlag, Autor autor) {
		for (Buch verlagBuch : verlag.getBücher()) {
			if (verlagBuch.getAutoren().contains(autor)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean isVerlagInOtherBücherOfAutor(Autor autor, Verlag verlag) {
		for (Buch autorBuch : autor.getBücher()) {
			if (autorBuch.getVerläge().contains(verlag)) {
				return true;
			}
		}
		return false;
	}


	public boolean isBuchTypInOtherBücherOfBücherVerwaltung(BuchTyp buchTyp) {
		for (Buch bücherVerwaltungBuch : this.bücherVerwaltung.getBücher()) {
			if (bücherVerwaltungBuch.getBuchTyp().equals(buchTyp)) {
				return true;
			}
		}
		return false;
	}
}
