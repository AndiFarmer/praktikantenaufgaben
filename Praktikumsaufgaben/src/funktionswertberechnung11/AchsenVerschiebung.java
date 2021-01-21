package funktionswertberechnung11;

public class AchsenVerschiebung {
 
	private double xVerschiebung = 0;
	private double yVerschiebung = 0;
	
	public AchsenVerschiebung() {

	}
	
	public double getXVerschiebung() {
		return xVerschiebung;
	}
	
	public double getYVerschiebung() {
		return yVerschiebung;
	}
	
	public void calcXYVerschiebung (Graph meinMaxMinRechner, Fenster fenster, boolean schonAusgeführt) {
		
		double fensterBreite = fenster.getFensterBreite();
		double fensterHöhe = fenster.getFensterHöhe();
		double xMinVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getXMin(), 2), 0.5);
		double xMaxVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getXMax(), 2), 0.5);
		double yMinVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getYMin(), 2), 0.5);
		double yMaxVorzeichenBereinigt = Math.pow(Math.pow(meinMaxMinRechner.getYMax(), 2), 0.5);
		
		if (schonAusgeführt == false) {
			if(xMinVorzeichenBereinigt > xMaxVorzeichenBereinigt) {
				xVerschiebung = xMinVorzeichenBereinigt;
			}else {
				xVerschiebung = xMaxVorzeichenBereinigt;
			}
			if(yMinVorzeichenBereinigt > yMaxVorzeichenBereinigt) {
				yVerschiebung = yMinVorzeichenBereinigt;
			}else {
				yVerschiebung = yMaxVorzeichenBereinigt;
			}
		}else {
			xVerschiebung = fensterBreite/2;
			yVerschiebung = fensterHöhe/2;
		}
	}
}
