package funktionswertberechnung11;

public class AchsenVerschiebung {

	public AchsenVerschiebung() {
		// TODO Auto-generated constructor stub
	}
	
	public static double achsenVerschiebung (double achseMin, double achseMax, double fensterGröße, boolean schonAusgeführt) {
		/**
		 * Wenn die xVerschiebung berechnet werden soll, dann ist bei der fensterGröße die fensterBreite einzugeben(bei der yVerschiebung entsprechend die FensterHöhe)  
		 */
		double achseVerschiebung;
		double MinVorzeichenbereinigt = Math.pow(Math.pow(achseMin, 2), 0.5);
		double MaxVorzeichenbereinigt = Math.pow(Math.pow(achseMax, 2), 0.5);
		if (schonAusgeführt == false) {
			if(MinVorzeichenbereinigt > MaxVorzeichenbereinigt) {
				achseVerschiebung = MinVorzeichenbereinigt;
			}else {
				achseVerschiebung = MaxVorzeichenbereinigt;
			}
		}else {
			if(MinVorzeichenbereinigt > MaxVorzeichenbereinigt) {
				achseVerschiebung = fensterGröße/2;
			}else {
				achseVerschiebung = fensterGröße/2;
			}
		}
		return achseVerschiebung;
	}
}
