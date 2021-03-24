package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class VerlagInfoPanel extends InfoPanel{

	private BücherVerwaltung myBücherVerwaltung;

	public VerlagInfoPanel(BücherVerwaltung myBücherVerwaltung) {
		super();
		this.initialize(myBücherVerwaltung);
	}

	public void initialize(BücherVerwaltung myBücherVerwaltung) {
		this.add(this.heading);
		this.add(this.separator);
		this.add(this.information);
		this.myBücherVerwaltung = myBücherVerwaltung;
		this.fillHeading();
		// nur Übergangsweise !!!
		Collection<Verlag> verläge1 = new ArrayList<Verlag>();
		verläge1.add(new Verlag("Scholastic Press", "New York"));
		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
		Collection<Autor> autoren1 = new ArrayList<>();
		autoren1.add(new Autor("Suzanne", "Collins"));
		Buch buch = new Buch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
		myBücherVerwaltung.addNewBuch(buch);
		Verlag verlag = myBücherVerwaltung.getVerläge().iterator().next();
		
		this.setInfo(verlag);
	}

	@Override
	protected void fillHeading() {
		this.getHeading().setText("Verlaginfos");
	}

	public void setInfo(Verlag verlag) {
		if (verlag == null) {
			return;
		}
		StringBuffer buchInformation = new StringBuffer();
		Iterator<Buch> bIter = verlag.getBücher().iterator();
		while (bIter.hasNext()) {
			Buch helpBuch = bIter.next();
			buchInformation.append(helpBuch.getTitel());
			if (bIter.hasNext()) {
				buchInformation.append(", ");
			}
		}
		StringBuffer autorenInformation = new StringBuffer();
		Iterator<Autor> aIter = verlag.getAutoren().iterator();
		while (aIter.hasNext()) {
			Autor helpAutor = aIter.next();
			autorenInformation.append(helpAutor.getVorName() + " " + helpAutor.getNachName());
			if (aIter.hasNext()) {
				autorenInformation.append(", ");
			}
		}
		
		StringBuffer allInformation = new StringBuffer();
		String doppelterZeilenUmbruch = System.lineSeparator() + System.lineSeparator();
		allInformation.append("Name: " + verlag.getName() + doppelterZeilenUmbruch + 
				"Ort: " + verlag.getOrt() + doppelterZeilenUmbruch + 
				"Bücher: " + buchInformation.toString() + doppelterZeilenUmbruch + 
				"Autoren: " + autorenInformation.toString());
		this.getInformation().setText(allInformation.toString());
	}
}
