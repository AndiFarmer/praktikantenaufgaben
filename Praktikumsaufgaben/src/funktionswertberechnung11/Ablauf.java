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
	//neue Variablen, bzw. veränderte
	protected Fenster fenster = new Fenster();
	final protected double fensterBreiteUrsprünglich = fenster.getFensterBreiteUrsprünglich();
	final protected double fensterHöheUrsprünglich = fenster.getFensterHöheUrsprünglich();
	protected double fensterBreite = fensterBreiteUrsprünglich;
	protected double fensterHöhe = fensterHöheUrsprünglich;
	
	
	//alte Variablen
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	final protected double fensterBreiteUrsprünglich = screenSize.width;
//	final protected double fensterHöheUrsprünglich = screenSize.height;
//	public double fensterBreite = fensterBreiteUrsprünglich;
//	protected double fensterHöhe = fensterHöheUrsprünglich;
//	protected double yMax = 0;
//	protected double yMin = 0;
//	protected double xMin= 0;
//	protected double xMax= 0;
	static protected boolean schonAusgeführt = false;
	protected double xVerschiebung = 0;
	protected double yVerschiebung = 0;
	protected JDialog dialog = new JDialog(); //Instanz der Klasse JDialog
	// private FensterAnpassung meinFensterAnpasser = null;
	private MaxMinRechner meinMaxMinRechner = new MaxMinRechner();
	protected Point[] punktArray = new Point[(int) (fensterBreite+1)];
	

	public Ablauf() {
		
		
		// meinFensterAnpasser = new FensterAnpassung(dialog);
		
		for (double xNow = -fensterBreiteUrsprünglich/2; xNow <= fensterBreiteUrsprünglich/2; xNow++) {
			double yNow = f(xNow);
			punktArray[(int) (xNow+ fensterBreiteUrsprünglich/2)] = new Point(xNow, yNow);
		}
		
		dialog.getContentPane().add(this);
		dialog.setTitle("Funktionsgraph");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocation(0, 0);
		dialog.setSize(0, 40);
		dialog.setVisible(true);
		
		//fenster.setVisibility(true);
	}
	
	public void paint(Graphics g) {
		if (schonAusgeführt == true) {
			fenster.updateBreite(dialog);
			fenster.updateHöhe(dialog);
			fensterBreite = fenster.getFensterBreite();
			fensterHöhe = fenster.getFensterHöhe();
			//fensterBreite = meinFensterAnpasser.breite(fensterBreite, fensterBreiteUrsprünglich);
			//fensterHöhe = meinFensterAnpasser.höhe(fensterHöhe, fensterHöheUrsprünglich);
		}

		if (schonAusgeführt == false) {
			// meinMaxMinRechner.berechneXYMaxMin(fenster, punktArray, fensterBreiteUrsprünglich);
			meinMaxMinRechner.calcXMin(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);
			meinMaxMinRechner.calcXMax(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);
			meinMaxMinRechner.calcYMin(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);
			meinMaxMinRechner.calcYMax(fensterBreite, fensterHöhe, punktArray, fensterBreiteUrsprünglich);
		}
		

		xVerschiebung = AchsenVerschiebung.calcXVerschiebung(meinMaxMinRechner, fensterBreite, schonAusgeführt);
		yVerschiebung = AchsenVerschiebung.calcYVerschiebung(meinMaxMinRechner, fensterHöhe, schonAusgeführt);
		
		new Zeichnen(punktArray, xVerschiebung, yVerschiebung, fensterBreiteUrsprünglich, g);
		
		System.out.printf("\nxMin=%.1f, xMax=%.1f, yMin=%.1f, yMax=%.1f\n",meinMaxMinRechner.getXMin(), meinMaxMinRechner.getXMax(), meinMaxMinRechner.getYMin(), meinMaxMinRechner.getYMax());
		System.out.printf("xVerschiebung=%.1f, yVerschiebung=%.1f, Fensterbreite=%.0f, Fensterhöhe=%.0f\n",xVerschiebung, yVerschiebung, fensterBreite, fensterHöhe);
		System.out.printf("Bildschirmbreite=%.0f, Bildschirmhöhe=%.0f\n",fensterBreiteUrsprünglich, fensterHöheUrsprünglich);
		dialog.setSize((int) (2*xVerschiebung), (int) (2*yVerschiebung));
		System.out.println(dialog.getContentPane().getBounds().getWidth() + "  "+ dialog.getContentPane().getBounds().getHeight());
		
		schonAusgeführt = true;
	}	

	abstract double f(double x);
	
}
