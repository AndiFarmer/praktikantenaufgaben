package bücherVerwaltung;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;

public class SuchPanel extends GblPanel {

	public SuchPanel(BücherVerwaltung myBücherVerwaltung) {
		super();
		JButton jButton = new JButton("SuchPanel");
//		Dimension dimension = new Dimension(300, 300);
//		this.setPreferredSize(dimension);
		this.add(jButton);
		this.setBackground(new Color(0));
	}

	@Override
	protected void configureGridBagConstraints() {
		
	}

}
