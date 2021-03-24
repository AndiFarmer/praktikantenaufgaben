package bücherVerwaltung;

import java.awt.Component;

import javax.swing.JPanel;

public class ResultsPanelManager {

	BuchResultsPanel myBuchResultsPanel;
//	AutorResultsPanel myAutorResultsPanel;
//	VerlagResultsPanel myVerlagResultsPanel;
	
	public ResultsPanelManager() {
		this.initialize();
	}

	public void initialize() {
		this.myBuchResultsPanel = new BuchResultsPanel();
		
}

	public ResultsPanel getDefault() {
		return this.myBuchResultsPanel;
	}

}
