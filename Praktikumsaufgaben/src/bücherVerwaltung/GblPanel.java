package bücherVerwaltung;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public abstract class GblPanel extends JPanel{

	private GridBagLayout gbl;
	
	public GblPanel() {
		this.gbl = new GridBagLayout();
		this.setLayout(this.gbl);
	}
	
	protected abstract void configureGridBagConstraints();

	public GridBagLayout getGbl() {
		return this.gbl;
	}

	public void setGbl(GridBagLayout gbl) {
		this.gbl = gbl;
	}
}
