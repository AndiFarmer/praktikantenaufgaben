package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;

public class BuchResultsPanel extends ResultsPanel {

	public BuchResultsPanel() {
		super();
		this.initialize();
	}

	public void initialize() {
//		JButton[] buttons = new JButton[10];
//		for (int i = 0; i < 10; i++) {
//			buttons[i] = new JButton("" + i);
//			this.configureGridBagConstraints(buttons[i], i);
//			this.add(buttons[i]);
//		}
		JButton ergebnis = new JButton("Ergebnis");
		JButton ergebnis2 = new JButton("Ergebnis2");
		this.configureGridBagConstraints(ergebnis, 0);
		this.configureGridBagConstraints(ergebnis2, 1);
//		this.setAlignmentY(Component.BOTTOM_ALIGNMENT);			//	funkt. nicht
//		ergebnis2.setAlignmentY(Component.BOTTOM_ALIGNMENT);	//	funkt. nicht
		this.setBackground(Color.black);
		this.add(ergebnis);
		this.add(ergebnis2);
	}

	public void showResults(ArrayList<Buch> results) {
		
	}
	
	@Override
	protected void configureGridBagConstraints() {
	}

	private void configureGridBagConstraints(JButton resultLine, int yValue) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = yValue;
		gbc.weighty = 0.1; // Muss iwie einen Wert über 1 haben damit der anchor funzt
		gbc.weightx = 0.1;
		gbc.anchor = GridBagConstraints.NORTH;
		this.getGbl().setConstraints(resultLine, gbc);
	}
}
