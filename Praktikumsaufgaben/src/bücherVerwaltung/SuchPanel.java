package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class SuchPanel extends GblPanel {
	
	SuchLeistePanel mySuchLeistePanel;
	ResultsPaneManager myResultsPaneManager;
	
	ResultsPane currentResultsPane;

	public SuchPanel(GroundPanel myGroundPanel) {
		super();
		this.initialize(myGroundPanel);
	}

	private void initialize(GroundPanel myGroundPanel) {
		this.mySuchLeistePanel = new SuchLeistePanel(myGroundPanel);
		this.myResultsPaneManager = new ResultsPaneManager();
		this.currentResultsPane = this.myResultsPaneManager.getDefault();
		this.configureGridBagConstraints();
		this.add(this.mySuchLeistePanel);
		this.add(this.currentResultsPane);
		ArrayList<Buch> defaultList = (ArrayList<Buch>) myGroundPanel.getMyBücherVerwaltung().getBücher();
//		ArrayList<Autor> defaultList = (ArrayList<Autor>) myGroundPanel.getMyBücherVerwaltung().getAutoren();
		this.myResultsPaneManager.showResults((ArrayList<Object>)(List<?>)defaultList, myGroundPanel);
	}

	@Override
	protected void configureGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		this.getGbl().setConstraints(this.mySuchLeistePanel, gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 1;
		gbc.weighty = 0.1;
		this.getGbl().setConstraints(this.currentResultsPane, gbc);
	}

}
