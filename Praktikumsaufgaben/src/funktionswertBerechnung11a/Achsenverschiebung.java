package funktionswertBerechnung11a;

import funktionswertberechnung11.Fenster;
import funktionswertberechnung11.Graph;

public class Achsenverschiebung {

	int xVerschiebung;
	int yVerschiebung;
	
	public Achsenverschiebung() {
		
	}
	
	public void calcXYVerschiebung (MinMax minMax,BildschirmAbmessungen bildschirmAbmessungen, boolean schonAusgeführt) {
		int xMin = minMax.getxMin();
		int xMax = minMax.getxMax();
		int yMin = minMax.getyMin();
		int yMax = minMax.getyMin();
		
		if (schonAusgeführt == false) { // NOCH NICHT KORREKT
			if(xMin > xMax) {
				xVerschiebung = xMin;
			}else {
				xVerschiebung = xMax;
			}
			if(yMin > yMax) {
				yVerschiebung = yMin;
			}else {
				yVerschiebung = yMax;
			}
		} else {
			xVerschiebung = bildschirmAbmessungen.getBreite()/2;
			yVerschiebung = bildschirmAbmessungen.getBreite()/2;
		}
		
	}
}
