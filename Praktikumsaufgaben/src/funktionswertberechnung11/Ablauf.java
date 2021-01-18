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
public abstract class Ablauf extends JPanel {
	/**
	 * Zeichnet Graph in einem Fenster(Dialog)
	 * @param args
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final protected double fensterBreiteUrsprünglich = screenSize.width;
	final protected double fensterHöheUrsprünglich = screenSize.height;
	protected double fensterBreite = fensterBreiteUrsprünglich;
	protected double fensterHöhe = fensterHöheUrsprünglich;
	protected double yMax = 0;
	protected double yMin = 0;
	protected double xMin= 0;
	protected double xMax= 0;
	protected boolean schonAusgeführt = false;
	protected double xVerschiebung = 0;
	protected double yVerschiebung = 0;
	protected JDialog dialog = new JDialog(); //Instanz der Klasse JDialog
	private FensterAnpassung meinFensterAnpasser = null;
	private MaxMinRechner meinMaxMinRechner = new MaxMinRechner();
	protected Point[] punktArray = new Point[(int) (fensterBreite+1)];
	
	public Ablauf() {
		
		meinFensterAnpasser = new FensterAnpassung(dialog);
		
		for (double xNow = -fensterBreiteUrsprünglich/2; xNow <= fensterBreiteUrsprünglich/2; xNow++) {
			double yNow = f(xNow);
			punktArray[(int) (xNow+ fensterBreiteUrsprünglich/2)] = new Point(xNow, yNow);
		}
		
		dialog.getContentPane().add(this);
		dialog.setTitle("Funktionsgraph");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocation(0, 0);
		//dialog.setUndecorated(true);
		dialog.setSize(0, 40);
		dialog.setVisible(true);
	}
	
	public void paint(Graphics g) {
		if (schonAusgeführt == true) {
			
			fensterBreite = meinFensterAnpasser.breite(fensterBreite, fensterBreiteUrsprünglich);
			fensterHöhe = meinFensterAnpasser.höhe(fensterHöhe, fensterHöheUrsprünglich);
		}

		xMin = MaxMinRechner.xMin(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);
		xMax = MaxMinRechner.xMax(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);
		yMin = MaxMinRechner.yMin(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);
		yMax = MaxMinRechner.yMax(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);

		// Damit der Graph in beide Richtungen(x & y), um den größeren Extremwert bzw. um die größere Grenze verschoben wird und somit alles sichtbar ist
		xVerschiebung = AchsenVerschiebung.achsenVerschiebung(xMin, xMax, fensterBreite, schonAusgeführt);
		yVerschiebung = AchsenVerschiebung.achsenVerschiebung(yMin, yMax, fensterHöhe, schonAusgeführt);

		new Zeichnen(xMin, punktArray, xVerschiebung, yVerschiebung, fensterBreiteUrsprünglich, g);
		
		System.out.printf("\nxMin=%.1f, xMax=%.1f, yMin=%.1f, yMax=%.1f\n",xMin, xMax, yMin, yMax);
		System.out.printf("xVerschiebung=%.1f, yVerschiebung=%.1f, Fensterbreite=%.0f, Fensterhöhe=%.0f\n",xVerschiebung, yVerschiebung, fensterBreite, fensterHöhe);
		System.out.printf("Bildschirmbreite=%.0f, Bildschirmhöhe=%.0f\n",fensterBreiteUrsprünglich, fensterHöheUrsprünglich);
		System.out.println(dialog.getContentPane().getBounds().getWidth() + "  "+ dialog.getContentPane().getBounds().getHeight());
		dialog.setSize((int) (2*xVerschiebung),(int) (2*yVerschiebung));
		schonAusgeführt = true;
	}	

	abstract double f(double x);
	
}
