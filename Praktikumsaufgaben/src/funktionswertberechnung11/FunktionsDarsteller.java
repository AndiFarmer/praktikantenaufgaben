package funktionswertberechnung11;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class FunktionsDarsteller extends JPanel {

	private JDialog dialog = new JDialog(); //Instanz der Klasse JDialog
	private boolean schonAusgeführt = false;
	
	AchsenVerschiebung meineAchsenVerschiebung = new AchsenVerschiebung();	
	Fenster fenster = new Fenster();
	Graph funktion = new Polynom(fenster);

	protected FunktionsDarsteller() {
		dialog.add(this);
		dialog.setTitle("Funktionsgraph");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(0, 40);
		dialog.setVisible(true);
		meineAchsenVerschiebung.calcXYVerschiebung (funktion);
	}
	
	
	public void paint(Graphics g) { // paint aus Klasse JPanel wird hier überschrieben
		fenster.updateMaße(dialog);

		if (schonAusgeführt == true) {
			meineAchsenVerschiebung.calcXYVerschiebung (fenster);
		}
		
		double xVerschiebung = meineAchsenVerschiebung.getXVerschiebung();
		double yVerschiebung = meineAchsenVerschiebung.getYVerschiebung();
		Point[] punktArray = funktion.getPunktArray();
		double xPrev=-xVerschiebung;
		double fensterBreiteUrsprünglich = fenster.getFensterBreiteUrsprünglich();

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
	}	
}
