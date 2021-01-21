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
	
	public void calcXYVerschiebung (Graph funktion) {
		
		double xMinVorzeichenlos = Math.pow(Math.pow(funktion.getXMin(), 2), 0.5);
		double xMaxVorzeichenlos = Math.pow(Math.pow(funktion.getXMax(), 2), 0.5);
		double yMinVorzeichenlos = Math.pow(Math.pow(funktion.getYMin(), 2), 0.5);
		double yMaxVorzeichenlos = Math.pow(Math.pow(funktion.getYMax(), 2), 0.5);
		
		
		if(xMinVorzeichenlos > xMaxVorzeichenlos) {
			xVerschiebung = xMinVorzeichenlos;
		}else {
			xVerschiebung = xMaxVorzeichenlos;
		}
		if(yMinVorzeichenlos > yMaxVorzeichenlos) {
			yVerschiebung = yMinVorzeichenlos;
		}else {
			yVerschiebung = yMaxVorzeichenlos;
		}
	}
	
	public void calcXYVerschiebung (Fenster fenster) {
		
		double fensterBreite = fenster.getFensterBreite();
		double fensterHöhe = fenster.getFensterHöhe();
		xVerschiebung = fensterBreite/2;
		yVerschiebung = fensterHöhe/2;
		
	}
}
