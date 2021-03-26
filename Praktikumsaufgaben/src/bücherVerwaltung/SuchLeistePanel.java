package bücherVerwaltung;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SuchLeistePanel extends JPanel {

	public SuchLeistePanel(GroundPanel myGroundPanel) {
		super();
		this.initialize(myGroundPanel);
	}
	
	public void initialize(GroundPanel myGroundPanel) {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel infoText = new JLabel("Wonach soll gesucht werden?");
		JRadioButton buchButton = new JRadioButton("Buch");
		JRadioButton autorButton = new JRadioButton("Autor");
		JRadioButton verlagButton = new JRadioButton("Verlag");
		ButtonGroup suchOptionen = new ButtonGroup();
		suchOptionen.add(buchButton);
		suchOptionen.add(autorButton);
		suchOptionen.add(verlagButton);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
//		gbc.weightx = 0.1;
		gbl.setConstraints(infoText, gbc);
		gbc.gridx = 1;
		gbl.setConstraints(buchButton, gbc);
		gbc.gridx = 2;
		gbl.setConstraints(autorButton, gbc);
		gbc.gridx = 3;
		gbl.setConstraints(verlagButton, gbc);
		this.setLayout(gbl);
		
		this.add(infoText);
		this.add(buchButton);
		this.add(autorButton);
		this.add(verlagButton);
	}
	
	
}
