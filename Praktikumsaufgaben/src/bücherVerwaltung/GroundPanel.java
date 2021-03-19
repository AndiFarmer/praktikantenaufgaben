package bücherVerwaltung;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class GroundPanel extends GblPanel {
	
	SuchPanel mySuchPanel;
	InfoPanelManager myInfoPanelManager;
	MenüLeistePanel myMenüLeistePanel;
	GridBagConstraints suchPanelGbc;
	GridBagConstraints infoPanelGbc;
	GridBagConstraints menüLeistePanelGbc;
	
	public GroundPanel() {
		super();
		this.mySuchPanel = new SuchPanel();
		this.myInfoPanelManager = new InfoPanelManager();
		this.myMenüLeistePanel = new MenüLeistePanel();
		this.configureGridBagConstraints();
		this.setLayout(this.getGbl());
		this.add(this.mySuchPanel);
		this.add(this.myInfoPanelManager.getDefaultPanel());
		
	}

	@Override
	public void configureGridBagConstraints() {
		this.setSuchPanelGbc(new GridBagConstraints());
		this.setInfoPanelGbc(new GridBagConstraints());
		this.setMenüLeistePanelGbc(new GridBagConstraints());
		
		this.getSuchPanelGbc().fill = GridBagConstraints.HORIZONTAL;
		this.getSuchPanelGbc().insets = new Insets(50, 50, 50, 50);
		this.getSuchPanelGbc().gridwidth = 2;
		this.getSuchPanelGbc().gridheight = 2;
		this.getSuchPanelGbc().gridx = 0;
		this.getSuchPanelGbc().gridy = 0;
		this.getGbl().setConstraints(this.getMySuchPanel(), this.getSuchPanelGbc());
		
		this.getInfoPanelGbc().fill = GridBagConstraints.BOTH;
		this.getInfoPanelGbc().insets = new Insets(5, 5, 5, 5);
		this.getInfoPanelGbc().gridx = 1;
		this.getInfoPanelGbc().gridy = 0;
		this.getInfoPanelGbc().gridheight = 2; 
		this.getGbl().setConstraints(this.getMyInfoPanelManager().getDefaultPanel(), this.getInfoPanelGbc());
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

	public GridBagConstraints getSuchPanelGbc() {
		return this.suchPanelGbc;
	}

	public void setSuchPanelGbc(GridBagConstraints suchPanelGbc) {
		this.suchPanelGbc = suchPanelGbc;
	}

	public GridBagConstraints getInfoPanelGbc() {
		return this.infoPanelGbc;
	}

	public void setInfoPanelGbc(GridBagConstraints infoPanelGbc) {
		this.infoPanelGbc = infoPanelGbc;
	}

	public GridBagConstraints getMenüLeistePanelGbc() {
		return this.menüLeistePanelGbc;
	}

	public void setMenüLeistePanelGbc(GridBagConstraints menüLeistePanelGbc) {
		this.menüLeistePanelGbc = menüLeistePanelGbc;
	}

}
