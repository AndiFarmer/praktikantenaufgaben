package funktionswertBerechnung11a;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FunktionsZeichner extends JPanel {
	
	public FunktionsZeichner() {
		
	}
	
	
	public void paint(Graphics g) {
		int xPrev = meinXMinMax.getMin;
		int yPrev = meinYMinMax.getMin;
		double yNow;
		for (int xNow = 0; xNow <= ; xNow++) {
			
			yNow = punktArray[xNow].getYKoordinate();
			g.drawLine(xPrev, yPrev, xNow, yNow); // durch die Titelleiste wird das innere Fenster um 16 in x-Richtung und 39 in y-Richtung verkleinert
			yPrev=yNow;
			xPrev=xNow;
		}
	}

}
