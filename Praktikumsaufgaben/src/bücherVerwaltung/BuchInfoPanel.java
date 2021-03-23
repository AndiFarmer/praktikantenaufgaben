package bücherVerwaltung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class BuchInfoPanel extends InfoPanel {

	BücherVerwaltung myBücherVerwaltung;
	
	public BuchInfoPanel(BücherVerwaltung myBücherVerwaltung) {
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
		
		this.fillInformation(buch);
	}


	@Override
	protected void fillHeading() {
		this.getHeading().setText("Buchinfos");
	}

	private void fillInformation(Buch buch) {
		if (buch == null) {
			return;
		}
		
		StringBuffer autorenInformation = new StringBuffer();
		Iterator<Autor> aIter = buch.getAutoren().iterator();
		while (aIter.hasNext()) {
			Autor helpAutor = aIter.next();
			autorenInformation.append(helpAutor.getVorName() + " " + helpAutor.getNachName());
			if (aIter.hasNext()) {
				autorenInformation.append(", ");
			}
		}
		
		StringBuffer verlägeInformation = new StringBuffer();
		Iterator<Verlag> vIter = buch.getVerläge().iterator();
		while (vIter.hasNext()) {
			Verlag helpVerlag = vIter.next();
			verlägeInformation.append(helpVerlag.getName() + " " + helpVerlag.getOrt());
			if (vIter.hasNext()) {
				verlägeInformation.append(", ");
			}
		}
		
		StringBuffer allInformation = new StringBuffer();
		String doppelterZeilenUmbruch = System.lineSeparator() + System.lineSeparator();
		allInformation.append("Titel: \"" + buch.getTitel() + "\"" + doppelterZeilenUmbruch + 
				"Erscheinungsjahr: " + buch.getErscheinungsJahr() + doppelterZeilenUmbruch + 
				"Autoren: " + autorenInformation.toString() + doppelterZeilenUmbruch + 
				"Verläge: " + verlägeInformation.toString() + doppelterZeilenUmbruch + 
				"Buchtyp: " + buch.getBuchTyp().getBezeichnung());
		this.getInformation().setText(allInformation.toString());
	}

}
