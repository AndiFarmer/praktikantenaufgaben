package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;

public class SuchPanel extends GblPanel {
	
	SuchLeistePanel mySuchLeistePanel;
	ResultsPanelManager myResultsPanelManager;
	
	ResultsPanel currentResultsPanel;

	public SuchPanel(BücherVerwaltung myBücherVerwaltung) {
		super();
		this.initialize(myBücherVerwaltung);
	}

	private void initialize(BücherVerwaltung myBücherVerwaltung) {
		this.mySuchLeistePanel = new SuchLeistePanel(myBücherVerwaltung);
		this.myResultsPanelManager = new ResultsPanelManager();
		this.currentResultsPanel = this.myResultsPanelManager.getDefault();
		this.configureGridBagConstraints();
		this.add(this.mySuchLeistePanel);
		
		this.add(this.currentResultsPanel);
	}

	@Override
	protected void configureGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		this.getGbl().setConstraints(this.mySuchLeistePanel, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 1;
		gbc.weighty = 1;
		this.getGbl().setConstraints(this.currentResultsPanel, gbc);
	}

}
