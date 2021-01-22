package funktionswertBerechnung11a;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Zeichner extends JPanel {
	
	public Zeichner() {
		ObjectHolder.dialog.add(this);
	}
	
	
	public void paint(Graphics g) {
		
		for (double x = ; x <= xVerschiebung; xNow++) {
			
			double yNow = punktArray[(int) (xNow + fensterBreiteUrsprünglich/2) ].getYKoordinate();
			g.drawLine((int) (xPrev+xVerschiebung-8), (int) (yPrev+yVerschiebung-20), (int) (xNow+xVerschiebung-8), (int) (yNow+yVerschiebung-20)); // durch die Titelleiste wird das innere Fenster um 16 in x-Richtung und 39 in y-Richtung verkleinert
			g.drawLine((int) (xVerschiebung+xVerschiebung-8), (int) yVerschiebung-20, (int) (xVerschiebung-xVerschiebung-8), (int) yVerschiebung-20);
			g.drawLine((int) (xVerschiebung-8), (int) (yVerschiebung+yVerschiebung-20), (int) (xVerschiebung-8), (int) (yVerschiebung-yVerschiebung-20));
			yPrev=yNow;
			xPrev=xNow;
		}
	}

}
