package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanelManager {

//	BuchInfoPanel myBuchInfoPanel;
//	AutorInfoPanel myAutorInfoPanel;
//	VerlagInfoPanel myVerlagInfoPanel;
	
	public InfoPanelManager() {
		
	}

	public Component getDefaultPanel() {
		JPanel testP = new JPanel();
		testP.setBackground(new Color(0));
//		testP.setLayout(new GridBagLayout());
		testP.
		testP.setSize(300,300);
		testP.add(new JButton("InfoPanel"));
		testP.add(new JLabel("dshfkjdsff"));
		return testP; // Später das BuchInfoPanel
	}
}
