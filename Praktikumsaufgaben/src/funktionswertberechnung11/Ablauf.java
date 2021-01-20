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
	
	private Fenster fenster = new Fenster();
	private MaxMinRechner meinMaxMinRechner = new MaxMinRechner();
	private AchsenVerschiebung meineAchsenVerschiebung = new AchsenVerschiebung();
	private Point[] punktArray;
	private JDialog dialog = new JDialog(); //Instanz der Klasse JDialog
	final private double fensterBreiteUrsprünglich;
	final private double fensterHöheUrsprünglich;
	private double fensterBreite = 0;
	private double fensterHöhe = 0;
	private boolean schonAusgeführt = false;
	private double xVerschiebung = 0;
	private double yVerschiebung = 0;

	protected Ablauf() {
		fensterBreiteUrsprünglich = fenster.getFensterBreiteUrsprünglich();
		fensterHöheUrsprünglich = fenster.getFensterHöheUrsprünglich();
		fensterBreite = fensterBreiteUrsprünglich;
		fensterHöhe = fensterHöheUrsprünglich;
		punktArray = new Point[(int) (fensterBreite+1)];
		
		for (double xNow = -fensterBreiteUrsprünglich/2; xNow <= fensterBreiteUrsprünglich/2; xNow++) {
			double yNow = f(xNow);
			punktArray[(int) (xNow+ fensterBreiteUrsprünglich/2)] = new Point(xNow, yNow);
		}
		
		dialog.add(this);
		//dialog.getContentPane().add(this);
		dialog.setTitle("Funktionsgraph");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocation(0, 0);
		dialog.setSize(0, 40);
		dialog.setVisible(true);
		
		//fenster.setVisibility(true);
	}
	
	public void paint(Graphics g) { // paint aus der Klasse JPanel wird hier überschrieben
		
		if (schonAusgeführt == true) {
			fenster.updateBreite(dialog);
			fenster.updateHöhe(dialog);
			fensterBreite = fenster.getFensterBreite();
			fensterHöhe = fenster.getFensterHöhe();
		}

		if (schonAusgeführt == false) {
			meinMaxMinRechner.calcXYMaxMin(fenster, punktArray);
		}
		
		meineAchsenVerschiebung.calcXYVerschiebung(meinMaxMinRechner, fenster, schonAusgeführt);
		xVerschiebung = meineAchsenVerschiebung.getXVerschiebung();
		yVerschiebung = meineAchsenVerschiebung.getYVerschiebung();
		
		double xPrev=-xVerschiebung;
		double yPrev=punktArray[(int) (xPrev + fensterBreiteUrsprünglich/2) ].getYKoordinate(); // ==f(xPrev)
		
		for (double xNow = -xVerschiebung; xNow <= xVerschiebung; xNow++) {
			
			double yNow = punktArray[(int) (xNow + fensterBreiteUrsprünglich/2) ].getYKoordinate();
			g.drawLine((int) (xPrev+xVerschiebung-8), (int) (yPrev+yVerschiebung-20), (int) (xNow+xVerschiebung-8), (int) (yNow+yVerschiebung-20)); // durch die Titelleiste wird das innere Fenster um 16 in x-Richtung und 39 in y-Richtung verkleinert
			g.drawLine((int) (xVerschiebung+xVerschiebung-8), (int) yVerschiebung-20, (int) (xVerschiebung-xVerschiebung-8), (int) yVerschiebung-20);
			g.drawLine((int) (xVerschiebung-8), (int) (yVerschiebung+yVerschiebung-20), (int) (xVerschiebung-8), (int) (yVerschiebung-yVerschiebung-20));
			yPrev=yNow;
			xPrev=xNow;
		}
		
		dialog.setSize((int) (2*xVerschiebung), (int) (2*yVerschiebung));
		schonAusgeführt = true;
		printVariablen();
	}	

	abstract double f(double x);
	
	private void printVariablen() {
		System.out.printf("\nxMin=%.1f, xMax=%.1f, yMin=%.1f, yMax=%.1f\n",meinMaxMinRechner.getXMin(), meinMaxMinRechner.getXMax(), meinMaxMinRechner.getYMin(), meinMaxMinRechner.getYMax());
		System.out.printf("xVerschiebung=%.1f, yVerschiebung=%.1f, Fensterbreite=%.0f, Fensterhöhe=%.0f\n",xVerschiebung, yVerschiebung, fensterBreite, fensterHöhe);
		System.out.printf("Bildschirmbreite=%.0f, Bildschirmhöhe=%.0f\n",fensterBreiteUrsprünglich, fensterHöheUrsprünglich);
		System.out.println(dialog.getContentPane().getBounds().getWidth() + "  "+ dialog.getContentPane().getBounds().getHeight());
	}
}
