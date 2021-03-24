package bücherVerwaltung;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class SuchLeistePanel extends JPanel {

	BücherVerwaltung myBücherVerwaltung;
	
	public SuchLeistePanel(BücherVerwaltung myBücherVerwaltung) {
		super();
		this.initialize(myBücherVerwaltung);
	}
	
	public void initialize(BücherVerwaltung myBücherVerwaltung) {
		this.myBücherVerwaltung = myBücherVerwaltung;
	}
}
