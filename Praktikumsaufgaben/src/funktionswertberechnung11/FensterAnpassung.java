package funktionswertberechnung11;

import javax.swing.JDialog;

public class FensterAnpassung {

	JDialog dialog= null;
	
	public FensterAnpassung(JDialog dialog) {
		this.dialog = dialog;
	}
	
	public double breite(double fensterbreite, double fensterbreiteUrsprünglich) {
		double realFensterBreite = dialog.getSize().width;
		if(fensterbreite<=fensterbreiteUrsprünglich && realFensterBreite <= fensterbreiteUrsprünglich) {
			fensterbreite = realFensterBreite;
		}
		
		return fensterbreite;
	}
	
	public double höhe(double fensterhöhe, double fensterhöheUrsprünglich) {
		double realFensterHöhe = dialog.getSize().height;
		if(fensterhöhe<=fensterhöheUrsprünglich && realFensterHöhe <= fensterhöheUrsprünglich) {
			fensterhöhe = realFensterHöhe;
		}
		return fensterhöhe;
	}

}
