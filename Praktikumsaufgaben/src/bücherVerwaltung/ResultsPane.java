package bücherVerwaltung;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

public abstract class ResultsPane extends JScrollPane {

	public ResultsPane() {
		this.setPreferredSize(new Dimension(300, 500));
	}
	
}
