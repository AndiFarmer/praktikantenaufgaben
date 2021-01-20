package funktionswertberechnung11;

import java.awt.Graphics;

public class Zeichnen {

	public Zeichnen(Point[] punktArray, double xVerschiebung, double yVerschiebung, double fensterbreiteUrsprünglich,Graphics g) {
		double xPrev=-xVerschiebung;
		double yPrev=punktArray[(int) (xPrev + fensterbreiteUrsprünglich/2) ].getYKoordinate(); // ==f(xPrev)
		for (double xNow = -xVerschiebung; xNow <= xVerschiebung; xNow++) {
			
			double yNow = punktArray[(int) (xNow + fensterbreiteUrsprünglich/2) ].getYKoordinate();
			g.drawLine((int) (xPrev+xVerschiebung-8), (int) (yPrev+yVerschiebung-20), (int) (xNow+xVerschiebung-8), (int) (yNow+yVerschiebung-20)); // durch die Titelleiste wird das innere Fenster um 16 in x-Richtung und 39 in y-Richtung verkleinert
			g.drawLine((int) (xVerschiebung+xVerschiebung-8), (int) yVerschiebung-20, (int) (xVerschiebung-xVerschiebung-8), (int) yVerschiebung-20);
			g.drawLine((int) (xVerschiebung-8), (int) (yVerschiebung+yVerschiebung-20), (int) (xVerschiebung-8), (int) (yVerschiebung-yVerschiebung-20));
			yPrev=yNow;
			xPrev=xNow;
		}
	}

}
