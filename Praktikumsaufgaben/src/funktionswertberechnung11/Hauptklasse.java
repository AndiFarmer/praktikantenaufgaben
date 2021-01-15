package funktionswertberechnung11;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;
/**
 * 
 * @author z1300a2k
 *
 */
public abstract class Hauptklasse extends JPanel {
	/**
	 * Zeichnet Graph in einem Fenster(Dialog)
	 * @param args
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final protected double fensterbreiteUrsprünglich = screenSize.width;
	final protected double fensterhöheUrsprünglich = screenSize.height;
	protected double fensterbreite = fensterbreiteUrsprünglich;
	protected double fensterhöhe = fensterhöheUrsprünglich;
	protected double yMax = 0;
	protected double yMin = 0;
	protected double xMin= 0;
	protected double xMax= 0;
	protected boolean schonAusgeführt = false;
	protected double xVerschiebung = 0;
	protected double yVerschiebung = 0;
	protected JDialog dialog = new JDialog(); //Instanz der Klasse JDialog
	protected Point[] punktArray = new Point[(int) (fensterbreite+1)];
	
public Hauptklasse() {
	
	
		dialog.getContentPane().add(this);
		dialog.setTitle("Funktionsgraph");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocation(0, 0);
		
		for (double xWert = -fensterbreiteUrsprünglich/2; xWert <= fensterbreiteUrsprünglich/2; xWert++) {
			double xNow = xWert;
			double yNow = f(xNow);
			punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2)] = new Point(xNow, yNow);
		}
		
		dialog.setVisible(true);
}
	
	public void paint(Graphics g) {
		if (schonAusgeführt == true) {
			fensterbreite = fensterAnpassung.breite(fensterbreite, fensterbreiteUrsprünglich, dialog);
			fensterhöhe = fensterAnpassung.höhe(fensterbreite, fensterbreiteUrsprünglich, dialog, fensterhöheUrsprünglich);
		}

		xMin = MaxMinRechner.xMin(fensterbreite, fensterhöhe, punktArray, fensterbreiteUrsprünglich);
		xMax = MaxMinRechner.xMax(fensterbreite, fensterhöhe, punktArray, fensterbreiteUrsprünglich);
		yMin = MaxMinRechner.yMin(fensterbreite, fensterhöhe, punktArray, fensterbreiteUrsprünglich);
		yMax = MaxMinRechner.yMax(fensterbreite, fensterhöhe, punktArray, fensterbreiteUrsprünglich);

		// Damit der Graph in beide Richtungen(x & y), um den größeren Extremwert bzw. um die größere Grenze verschoben wird und somit alles sichtbar ist
		double xMinVorzeichenbereinigt = Math.pow(Math.pow(xMin, 2), 0.5);
		double xMaxVorzeichenbereinigt = Math.pow(Math.pow(xMax, 2), 0.5);
		double yMinVorzeichenbereinigt = Math.pow(Math.pow(yMin, 2), 0.5);
		double yMaxVorzeichenbereinigt = Math.pow(Math.pow(yMax, 2), 0.5);
		if (schonAusgeführt == false) {
			if(xMinVorzeichenbereinigt > xMaxVorzeichenbereinigt) {
				xVerschiebung = xMinVorzeichenbereinigt;
			} else {
				xVerschiebung = xMaxVorzeichenbereinigt; // Vorzeichenbereinigt, Weil auch xMax im Negativen liegen könnte, aber nur positivie Zahlen zum Verschieben des Graphen geeignet sind.
			}
			if(yMinVorzeichenbereinigt > yMaxVorzeichenbereinigt) {
				yVerschiebung = yMinVorzeichenbereinigt;
			} else {
				yVerschiebung = yMaxVorzeichenbereinigt; // Gleicher Grund wie 5 Zeilen drüber
			}
		}else {
			if(xMinVorzeichenbereinigt > xMaxVorzeichenbereinigt) {
				xVerschiebung = fensterbreite/2;
			} else {
				xVerschiebung = fensterbreite/2;
			}
			if(yMinVorzeichenbereinigt > yMaxVorzeichenbereinigt) {
				yVerschiebung = fensterhöhe/2;
			} else {
				yVerschiebung = fensterhöhe/2;
			}
		}
		
		
		new Zeichnen(xMin, punktArray, xVerschiebung, yVerschiebung, fensterbreiteUrsprünglich, g);
		
		
		System.out.printf("\nxMin=%.1f, xMax=%.1f, yMin=%.1f, yMax=%.1f\n",xMin, xMax, yMin, yMax);
		System.out.printf("xVerschiebung=%.1f, yVerschiebung=%.1f, Fensterbreite=%d, Fensterhöhe=%d\n",xVerschiebung, yVerschiebung, dialog.getSize().width, dialog.getSize().height);
		System.out.printf("Bildschirmbreite=%d, Bildschirmhöhe=%d\n",screenSize.width, screenSize.height);
		dialog.setSize((int) (2*xVerschiebung),(int) (2*yVerschiebung));
		schonAusgeführt = true;
		
	}

	abstract double f(double x);
	
	

}
