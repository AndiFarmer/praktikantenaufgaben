package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class VerlagInfoPanel extends InfoPanel{

	public VerlagInfoPanel(GroundPanel groundPanel) {
		super();
		this.initialize(groundPanel);
	}

	public void initialize(GroundPanel groundPanel) {
		this.add(this.heading);
		this.add(this.separator);
		this.add(this.information);
		this.fillHeading();
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
