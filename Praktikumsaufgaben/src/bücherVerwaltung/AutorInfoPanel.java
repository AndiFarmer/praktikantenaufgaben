package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AutorInfoPanel extends InfoPanel {

	public AutorInfoPanel(GroundPanel groundPanel) {
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
		this.getHeading().setText("Autorinfos");
	}
	
	public void setInfo(Autor autor) {
		if (autor == null) {
			return;
		}
		StringBuffer buchInformation = new StringBuffer();
		Iterator<Buch> bIter = autor.getBücher().iterator();
		while (bIter.hasNext()) {
			Buch helpBuch = bIter.next();
			buchInformation.append(helpBuch.getTitel());
			if (bIter.hasNext()) {
				buchInformation.append(", ");
			}
		}
		StringBuffer verlägeInformation = new StringBuffer();
		Iterator<Verlag> vIter = autor.getVerläge().iterator();
		while (vIter.hasNext()) {
			Verlag helpVerlag = vIter.next();
			verlägeInformation.append(helpVerlag.getName() + " " + helpVerlag.getOrt());
			if (vIter.hasNext()) {
				verlägeInformation.append(", ");
			}
		}
		
		StringBuffer allInformation = new StringBuffer();
		String doppelterZeilenUmbruch = System.lineSeparator() + System.lineSeparator();
		allInformation.append("Vorname: " + autor.getVorName() + doppelterZeilenUmbruch + 
				"Nachname: " + autor.getNachName() + doppelterZeilenUmbruch + 
				"Bücher: " + buchInformation.toString() + doppelterZeilenUmbruch + 
				"Verläge: " + verlägeInformation.toString() + doppelterZeilenUmbruch);
		this.getInformation().setText(allInformation.toString());
	}

}
