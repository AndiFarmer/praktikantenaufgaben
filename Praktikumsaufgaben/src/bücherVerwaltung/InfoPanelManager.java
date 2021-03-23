package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanelManager {

	BuchInfoPanel myBuchInfoPanel;
//	AutorInfoPanel myAutorInfoPanel;
//	VerlagInfoPanel myVerlagInfoPanel;
	
	public InfoPanelManager(BücherVerwaltung myBücherVerwaltung) {
		this.myBuchInfoPanel = new BuchInfoPanel(myBücherVerwaltung);
	}

	public JPanel getDefaultPanel() {
		return this.myBuchInfoPanel;
	}
}
