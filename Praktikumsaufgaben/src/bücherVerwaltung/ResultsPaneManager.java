package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class ResultsPaneManager {

	BuchResultsPane myBuchResultsPane;
	AutorResultsPane myAutorResultsPane;
//	VerlagResultsPane myVerlagResultsPane;
	
	public ResultsPaneManager() {
		this.initialize();
	}

	public void initialize() {
		this.myBuchResultsPane = new BuchResultsPane();
		this.myAutorResultsPane = new AutorResultsPane();
	}

	public ResultsPane getDefault() {
		return this.myBuchResultsPane;
//		return this.myAutorResultsPane;
	}
	
	public void showResults(ArrayList<Object> results, GroundPanel groundPanel) {
		if (results == null || results.isEmpty()) {
			// Meldung hinzufügen, dass keine Ergebnisse gefunden wurden
			return;
		}
		if (results.get(0) instanceof Buch) { // funktioniert auch mit Interfaces
			this.myBuchResultsPane.showResults((ArrayList<Buch>) (List<?>) results, groundPanel);
			return;
		}
		if (results.get(0) instanceof Autor) {
			this.myAutorResultsPane.showResults((ArrayList<Autor>) (List<?>) results, groundPanel);
			return;
		}
	}

}
