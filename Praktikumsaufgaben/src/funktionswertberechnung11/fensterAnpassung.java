package funktionswertberechnung11;

import javax.swing.JDialog;

public class fensterAnpassung {

	public fensterAnpassung() {
		// TODO Auto-generated constructor stub
	}
	
	public static double breite(double fensterbreite, double fensterbreiteUrsprünglich, JDialog dialog) {
		if(fensterbreite<=fensterbreiteUrsprünglich) {
			fensterbreite = dialog.getSize().width;
		} else {
			fensterbreite = fensterbreiteUrsprünglich;
		}
		return fensterbreite;
	}
	
	public static double höhe(double fensterbreite, double fensterbreiteUrsprünglich, JDialog dialog, double fensterhöheUrsprünglich) {
		double fensterhöhe =0;
		if(fensterbreite<=fensterbreiteUrsprünglich) {
			fensterbreite = dialog.getSize().width;
			fensterhöhe = dialog.getSize().height;
		} else {
			fensterbreite = fensterbreiteUrsprünglich;
			fensterhöhe = fensterhöheUrsprünglich;
		}
		return fensterhöhe;
	}

}
