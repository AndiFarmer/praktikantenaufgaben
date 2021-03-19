package bücherVerwaltung;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

public class SuchPanel extends GblPanel {

	public SuchPanel() {
		this.add(new JButton("SuchPanel"));
		this.setSize(300, 300);
		this.setBackground(new Color(0));
	}

	@Override
	public void configureGridBagConstraints() {
		
	}

}
