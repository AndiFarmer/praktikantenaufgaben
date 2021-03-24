package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class BuchResultsPanel extends ResultsPanel {

	public BuchResultsPanel() {
		super();
		this.initialize();
	}

	public void initialize() {
		// übergangsweise
		Collection<Verlag> verläge1 = new ArrayList<Verlag>();
		verläge1.add(new Verlag("Scholastic Press", "New York"));
		BuchTyp buchTyp1 = new BuchTyp("Hardcover");
		Collection<Autor> autoren1 = new ArrayList<>();
		autoren1.add(new Autor("Suzanne", "Collins"));
		Buch buch = new Buch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
		Collection<Verlag> verläge2 = new ArrayList<>();
		verläge2.add(new Verlag("Verlagname", "Verlagort"));
		BuchTyp buchTyp2 = new BuchTyp("Online");
		Collection<Autor> autoren2 = new ArrayList<>();
		autoren2.add(new Autor("Vorname2", "Nachname2"));
		Buch buch2 = new Buch("Buch Zwei", "DiesIstISBN", 2021, verläge1, buchTyp2, autoren2);
		ArrayList<Buch> buchListe = new ArrayList<>();
		buchListe.add(buch2);
		buchListe.add(buch);
		this.showResults(buchListe);
		
		
//		JButton[] buttons = new JButton[10];
//		for (int i = 0; i < 10; i++) {
//			buttons[i] = new JButton("" + i);
//			this.configureGridBagConstraints(buttons[i], i);
//			this.add(buttons[i]);
//		}
//		JButton ergebnis = new JButton("Ergebnis");
//		JButton ergebnis2 = new JButton("Ergebnis2");
//		this.configureGridBagConstraints(ergebnis, 0);
//		this.configureGridBagConstraints(ergebnis2, 1);
//		this.setAlignmentY(Component.BOTTOM_ALIGNMENT);			//	funkt. nicht
//		ergebnis2.setAlignmentY(Component.BOTTOM_ALIGNMENT);	//	funkt. nicht
//		this.setBackground(Color.black);
//		this.add(ergebnis);
//		this.add(ergebnis2);
	}

	public void showResults(ArrayList<Buch> resultsInput) {
		JList results = new JList(resultsInput.toArray());
		results.setLayoutOrientation(JList.VERTICAL);
		System.out.println(results.getLayoutOrientation());
		results.setVisibleRowCount(2); // Warum funktioniert das nicht, schließlich ist das Layout VERTICAL (standardmäßig)
		results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.add(results);
	}
}
