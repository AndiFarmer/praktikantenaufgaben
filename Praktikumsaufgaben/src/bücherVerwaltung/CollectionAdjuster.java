package bücherVerwaltung;

import java.util.ArrayList;

public class CollectionAdjuster {

	BücherVerwaltung bücherVerwaltung;
	
	public CollectionAdjuster(BücherVerwaltung myBücherVerwaltung) {
		this.bücherVerwaltung = myBücherVerwaltung;
	}

	// falls der Benutzer später aus vorhandenen Listen Autoren auswählt dann sind einige add-Funktionen und Referenzanpassungen unnötig
	public void adjustCollectionsEffectedByBuchAdding(Buch buch) {
		this.bücherVerwaltung.getBücher().add(buch); 
		this.adjustBuchTypenCollections(buch); 
		this.adjustCollectionsRest(buch); 
	}

	public void adjustCollectionsEffectedByBuchDeletion(Buch buch) {
//		Wenn ein Buch entfernt wird, muss geschaut werden, ob seine Attribute (Autoren, Verläge und BuchTypen)
//		noch in anderen Listen auftauchen. Falls nicht, kann der Autor/Verlag/BuchTyp auch aus der Gesamtliste in
//		der BücherVerwaltung ausgetragen werden.
		this.bücherVerwaltung.getBücher().remove(buch); // Der Schritt muss als Erstes erfolgen,
//		da in den folgenden Methoden in BücherVerwaltung.bücher geschaut wird,
//		ob noch andere Bücher die Verläge/Autoren/BuchTyp von dem zu löschenden Buch haben und wenn dann das Buch noch drin ist,
//		dann kommt bei der Prüfung true raus, obwohl es sich dabei ja unter Umständen nur um das zu löschende Buch handelt. 
		this.deleteUnnecessaryAutoren(buch);
		this.deleteUnnecessaryVerläge(buch);
		this.deleteUnnecessaryBuchTyp(buch);
		this.deleteBuchFromRemainingCollections(buch); // Am Ende sollte das Buch überall gelöscht sein, genauso wie seine Attribute,
//		wenn sie nirgendwo sonst auftauchten.
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
			buch.getAutoren().add(newAutor);// es muss nicht geprüft werden, ob schon vorhanden, da diese Funktion nur aufgerufen wird,
			// wenn ein dem Buch unbekannter Autor hinzugefügt wird
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
			buch.getVerläge().add(newVerlag); // es muss nicht geprüft werden, ob schon vorhanden, da diese Funktion nur aufgerufen wird,
			// wenn ein dem Buch unbekannter Verlag hinzugefügt wird 
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
		buch.getAutoren().remove(autorToBeRemoved); // Aus dem Buch muss der Autor auf jeden Fall raus, weil das der Hauptsinn der Methode ist.
		// Ansonsten muss der Autor auch noch in den Verlagen des Buches entfernt werden, 
		// wenn er nicht in einem anderen Buch des Verlags auftaucht.
		// Ebenso muss er aus der Gesamtliste der Klasse BücherVerwaltung ausgetragen werden,
		// wenn es insgesamt kein anderes Buch mit diesem Autoren gibt.
		if (this.isAutorInOtherBücherOfBücherVerwaltung(autorToBeRemoved)) { // Wenn er in keinen anderen Büchern ist,
			// kann man den Autoren direkt überall löschen (das passiert in else).
			for (Verlag verlag : buch.getVerläge()) { // Wenn der Autor auch noch in anderen Büchern auftaucht,
				// dann muss (weil es ja ganz offensichtlich noch andere Bücher mit dem Autoren gibt)
				// auch die Verläge (des Buches aus dem der autor entfernt wird) durchgegangen werden,
				// ob der Autor in deren Büchern auftaucht und nur wenn das nicht der Fall ist,
				// kann der Autor aus der Liste des Verlags ausgetragen werden.
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
	
	private boolean isAutorInOtherBücherOfBücherVerwaltung(Autor autor) {
		for (Buch bücherVerwaltungBuch : this.bücherVerwaltung.getBücher()) {
			if (bücherVerwaltungBuch.getAutoren().contains(autor)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isVerlagInOtherBücherOfBücherVerwaltung(Verlag verlag) {
		for (Buch bücherVerwaltungBuch : this.bücherVerwaltung.getBücher()) {
			if (bücherVerwaltungBuch.getVerläge().contains(verlag)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isAutorInOtherBücherOfVerlag(Verlag verlag, Autor autor) {
		for (Buch verlagBuch : verlag.getBücher()) {
			if (verlagBuch.getAutoren().contains(autor)) {
				return true;
			}
		}
		return false;
	}
	
	
	private boolean isVerlagInOtherBücherOfAutor(Autor autor, Verlag verlag) {
		for (Buch autorBuch : autor.getBücher()) {
			if (autorBuch.getVerläge().contains(verlag)) {
				return true;
			}
		}
		return false;
	}

	private boolean isBuchTypInOtherBücherOfBücherVerwaltung(BuchTyp buchTyp) {
		for (Buch bücherVerwaltungBuch : this.bücherVerwaltung.getBücher()) {
			if (bücherVerwaltungBuch.getBuchTyp().equals(buchTyp)) {
				return true;
			}
		}
		return false;
	}
	
	private void deleteUnnecessaryAutoren(Buch buch) {
		for (Autor autorToBeRemoved : buch.getAutoren()) {
			if (this.isAutorInOtherBücherOfBücherVerwaltung(autorToBeRemoved)) { // Wenn er in keinen anderen Büchern ist,
				// kann man den Autor direkt überall löschen (das passiert in else).
				for (Verlag verlag : buch.getVerläge()) { // Wenn der Autor auch noch in anderen Büchern auftaucht,
					// dann muss (weil es ja ganz offensichtlich noch andere Bücher mit dem Autor gibt)
					// auch die Verläge (des Buches aus dem der Autor entfernt wird) durchgegangen werden,
					// ob der Autor in deren Büchern auftaucht und nur wenn das nicht der Fall ist,
					// kann der Autor aus der Liste des Verlags ausgetragen werden.
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
	}
	
	private void deleteUnnecessaryVerläge(Buch buch) {
		for (Verlag verlagToBeRemoved : buch.getVerläge()) { // Die Verlage des Buches müssen durchgegangen werden,
			// damit geprüft werden, ob er insgesamt nicht mehr gebraucht wird oder ob durch andere Bücher,
			// die den Verlag haben, doch noch gebraucht wird und wenn ja wo.
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
	}
	
	private void deleteUnnecessaryBuchTyp(Buch buch) {
		if (! this.isBuchTypInOtherBücherOfBücherVerwaltung(buch.getBuchTyp())) { // Wenn der BuchTyp nur in diesem Buch vorkam,
			// dann kann man ihn nach Löschen dieses Buches auch aus der Gesamtliste entfernen
			this.bücherVerwaltung.getBuchTypen().remove(buch.getBuchTyp());
		}
	}
	

	private void deleteBuchFromRemainingCollections(Buch buch) {
		for (Autor autor : buch.getAutoren()) {
			autor.getBücher().remove(buch);
		}
		for (Verlag verlag : buch.getVerläge()) {
			verlag.getBücher().remove(buch);
		}
	}
}
