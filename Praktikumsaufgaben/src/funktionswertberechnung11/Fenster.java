package funktionswertberechnung11;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Fenster extends JPanel {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private final double fensterBreiteUrsprünglich;
	private final double fensterHöheUrsprünglich;
	private double fensterBreite = 0;
	private double fensterHöhe = 0;
	private JDialog dialog = new JDialog();
	
	
	protected Fenster() {
		fensterBreiteUrsprünglich = screenSize.width;
		fensterHöheUrsprünglich = screenSize.height;
		fensterBreite = fensterBreiteUrsprünglich;
		fensterHöhe = fensterHöheUrsprünglich;
	}
	
	
	protected double getFensterBreiteUrsprünglich() {
		return this.fensterBreiteUrsprünglich;
	}
	protected double getFensterHöheUrsprünglich() {
		return this.fensterHöheUrsprünglich;
	}
	protected double getFensterBreite() {
		return this.fensterBreite;
	}
	protected double getFensterHöhe() {
		return this.fensterHöhe;
	}
	protected JDialog getJDialog() {
		return this.dialog;
	}
	
	
	protected void updateBreite(JDialog dialog2) {
		fensterBreite = dialog2.getSize().width;
		if(fensterBreite > this.fensterBreiteUrsprünglich) {
			fensterBreite = fensterBreiteUrsprünglich;
		}
	}
	
	protected void updateHöhe(JDialog dialog2) {
		fensterHöhe = dialog2.getSize().height;
		if(fensterHöhe > fensterHöheUrsprünglich) {
			fensterHöhe = fensterHöheUrsprünglich;
		}
	}
	
}
