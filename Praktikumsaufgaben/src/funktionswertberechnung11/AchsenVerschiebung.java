package funktionswertberechnung11;

public class AchsenVerschiebung {
 
	public AchsenVerschiebung() {
		// TODO Auto-generated constructor stub
	}
	
	public static double calcXVerschiebung (MaxMinRechner meinMaxMinRechner, double fensterBreite, boolean schonAusgeführt) {
		/**
		 * Wenn die xVerschiebung berechnet werden soll, dann ist bei der fensterGröße die fensterBreite einzugeben(bei der yVerschiebung entsprechend die FensterHöhe)  
		 */
		
		double xVerschiebung;
		double xMinVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getXMin(), 2), 0.5);
		double yMaxVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getXMax(), 2), 0.5);
		if (schonAusgeführt == false) {
			if(xMinVorzeichenBereinigt > yMaxVorzeichenBereinigt) {
				xVerschiebung = xMinVorzeichenBereinigt;
			}else {
				xVerschiebung = yMaxVorzeichenBereinigt;
			}
		}else {
			if(xMinVorzeichenBereinigt > yMaxVorzeichenBereinigt) {
				xVerschiebung = fensterBreite/2;
			}else {
				xVerschiebung = fensterBreite/2;
			}
		}
		return xVerschiebung;
	}
	
	public static double calcYVerschiebung (MaxMinRechner meinMaxMinRechner, double fensterHöhe, boolean schonAusgeführt) {
		/**
		 * Wenn die xVerschiebung berechnet werden soll, dann ist bei der fensterGröße die fensterBreite einzugeben(bei der yVerschiebung entsprechend die FensterHöhe)  
		 */
		
		double yVerschiebung;
		double yMinVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getYMin(), 2), 0.5);
		double yMaxVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getYMax(), 2), 0.5);
		if (schonAusgeführt == false) {
			if(yMinVorzeichenBereinigt > yMaxVorzeichenBereinigt) {
				yVerschiebung = yMinVorzeichenBereinigt;
			}else {
				yVerschiebung = yMaxVorzeichenBereinigt;
			}
		}else {
			if(yMinVorzeichenBereinigt > yMaxVorzeichenBereinigt) {
				yVerschiebung = fensterHöhe/2;
			}else {
				yVerschiebung = fensterHöhe/2;
			}
		}
		return yVerschiebung;
	}
}
