package bücherVerwaltung;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FensterVerwalter {

	public FensterVerwalter() {
		
	}

	public void initStandardView () {
		JFrame myJFrame = new JFrame();
		myJFrame.add(this.initFirstPanelLayer());
	}
	
	private JPanel initFirstPanelLayer() {
		JPanel myJPanelEins = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		myJPanelEins.setLayout(gbl);
		return myJPanelEins;
	}
}
