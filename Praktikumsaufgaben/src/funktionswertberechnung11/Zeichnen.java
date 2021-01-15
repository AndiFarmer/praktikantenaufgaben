package funktionswertberechnung11;

import java.awt.Graphics;

public class Zeichnen {

	public Zeichnen(double xMin,Point[] punktArray, double xVerschiebung, double yVerschiebung, double fensterbreiteUrsprünglich,Graphics g) {
		double xPrev=xMin;
		double yPrev=punktArray[(int) (xPrev + fensterbreiteUrsprünglich/2) ].getYKoordinate(); // ==f(xPrev)
		for (double xWert = -xVerschiebung; xWert <= xVerschiebung; xWert++) {
			double xNow = xWert;
			double yNow = punktArray[(int) (xNow + fensterbreiteUrsprünglich/2) ].getYKoordinate(); // ==f(xNow);
			//System.out.printf("xNow=%.1f, yNow=%.1f, xPrev=%.1f, yPrev=%.1f\n", xNow,yNow,xPrev,yPrev);
			g.drawLine((int) (xPrev+xVerschiebung), (int) (yPrev+yVerschiebung), (int) (xNow+xVerschiebung), (int) (yNow+yVerschiebung));
			g.drawLine((int) (xVerschiebung+xVerschiebung), (int) yVerschiebung, (int) (xVerschiebung-xVerschiebung), (int) yVerschiebung);
			g.drawLine((int) xVerschiebung, (int) (yVerschiebung+yVerschiebung), (int) xVerschiebung, (int) (yVerschiebung-yVerschiebung));
			yPrev=yNow;
			xPrev=xNow;
		}
	}

}
