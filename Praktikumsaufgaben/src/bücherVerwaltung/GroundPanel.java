package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GroundPanel extends GblPanel {
	
	SuchPanel mySuchPanel;
	InfoPanelManager myInfoPanelManager;
	MenüLeistePanel myMenüLeistePanel;
	
	JPanel currentInfoPanel;
	
	public GroundPanel(BücherVerwaltung myBücherVerwaltung) {
		super();
		this.initialize(myBücherVerwaltung);
	}
	
	public void initialize(BücherVerwaltung myBücherVerwaltung) {
		this.mySuchPanel = new SuchPanel(myBücherVerwaltung);
		this.myInfoPanelManager = new InfoPanelManager(myBücherVerwaltung);
		this.myMenüLeistePanel = new MenüLeistePanel(myBücherVerwaltung);
		this.currentInfoPanel = this.myInfoPanelManager.getDefaultPanel();
		this.configureGridBagConstraints();
		this.add(this.mySuchPanel);
		this.add(this.currentInfoPanel);
		this.add(this.getMyMenüLeistePanel());
	}

	@Override
	protected void configureGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.getGbl().setConstraints(this.getMyMenüLeistePanel(), gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.ipadx = StandardView.screenDimension.width / 3;
		gbc.ipady = StandardView.screenDimension.height / 2;
		gbc.weightx = 1;
		this.getGbl().setConstraints(this.getMySuchPanel(), gbc);
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 1;
		gbc.ipadx = StandardView.screenDimension.width / 7;
		gbc.weightx = 0; // warum wird das mit 0 nicht verkleinert, mit 1 aber schon??
		gbc.weighty = 1;
		this.getGbl().setConstraints(this.currentInfoPanel, gbc);
	}

	public SuchPanel getMySuchPanel() {
		return this.mySuchPanel;
	}

	public void setMySuchPanel(SuchPanel mySuchPanel) {
		this.mySuchPanel = mySuchPanel;
	}

	public InfoPanelManager getMyInfoPanelManager() {
		return this.myInfoPanelManager;
	}

	public void setMyInfoPanelManager(InfoPanelManager myInfoPanelManager) {
		this.myInfoPanelManager = myInfoPanelManager;
	}

	public MenüLeistePanel getMyMenüLeistePanel() {
		return this.myMenüLeistePanel;
	}

	public void setMyMenüLeistePanel(MenüLeistePanel myMenüLeistePanel) {
		this.myMenüLeistePanel = myMenüLeistePanel;
	}

}
