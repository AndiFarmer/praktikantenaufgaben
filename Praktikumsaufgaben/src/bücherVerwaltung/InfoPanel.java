package bücherVerwaltung;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public abstract class InfoPanel extends GblPanel {

	JLabel heading;
	JSeparator separator;
	JTextPane information;
	
	public InfoPanel() {
		super();
		this.initialize();
	}

	private void initialize() { // da die Klasse abstrakt ist, wird niemals eine andere Klasse auf diese Methode zugreifen müssen
		this.heading = new JLabel();
		this.separator = new JSeparator();
		this.information = new JTextPane();
		this.configureGridBagConstraints();
		this.getHeading().setHorizontalAlignment(SwingConstants.CENTER);
		this.getHeading().setOpaque(true);
		this.getHeading().setBackground(Color.LIGHT_GRAY);
	}
	
	protected abstract void fillHeading();

	@Override
	protected void configureGridBagConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		this.getGbl().setConstraints(this.getHeading(), gbc);
		gbc.gridy = 1;
		gbc.weightx = 0;
		this.getGbl().setConstraints(this.getSeparator(), gbc);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 2;
		gbc.weighty = 1;
		this.getGbl().setConstraints(this.getInformation(), gbc);
	}
	
	public JLabel getHeading() {
		return this.heading;
	}

	public void setHeading(JLabel heading) {
		this.heading = heading;
	}

	public JSeparator getSeparator() {
		return this.separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public JTextPane getInformation() {
		return this.information;
	}

	public void setInformation(JTextPane information) {
		this.information = information;
	}

}
