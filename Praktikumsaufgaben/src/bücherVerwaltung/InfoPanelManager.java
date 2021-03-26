package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanelManager {

	private BuchInfoPanel myBuchInfoPanel;
	private VerlagInfoPanel myVerlagInfoPanel;
	private AutorInfoPanel myAutorInfoPanel;
	
	public InfoPanelManager(GroundPanel groundPanel) {
		this.initialize(groundPanel);
	}

	public void showInfo(Object input) throws BücherVerwaltungException {
		if (input.getClass() == Buch.class) {
			System.out.println("showInfo -> Manager");
			this.myBuchInfoPanel.setInfo((Buch) input);
			
			return;
		}
		if (input.getClass() == Autor.class) {
			System.out.println("showInfo -> Manager");
			this.myAutorInfoPanel.setInfo((Autor) input);
			
			return;
		}
		if (input.getClass() == Verlag.class) {
			this.myVerlagInfoPanel.setInfo((Verlag) input);
			
			return;
		}
		throw new BücherVerwaltungException("Das anzuzeigende Objekt muss der Klasse Buch, Autor oder Verlag angehören!");
	}

	public void initialize(GroundPanel groundPanel) {
		this.myBuchInfoPanel = new BuchInfoPanel(groundPanel);
		this.myVerlagInfoPanel = new VerlagInfoPanel(groundPanel);
		this.myAutorInfoPanel = new AutorInfoPanel(groundPanel);
	}

	
	
	public JPanel getDefaultPanel() {

		return this.myBuchInfoPanel;
//		return this.myVerlagInfoPanel;
//		return this.myAutorInfoPanel;
	}
}
