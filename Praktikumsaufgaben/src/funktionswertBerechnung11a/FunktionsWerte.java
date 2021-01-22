package funktionswertBerechnung11a;

public class FunktionsWerte {

	double[] yWertArray;
		
	public FunktionsWerte(int BildschirmBreite) {
		fillArray(BildschirmBreite);
	}
	
	private void fillArray(int BildschirmBreite) {
		Funktion funktion = new PolynomFunktion();
		yWertArray = new double[BildschirmBreite];
		for(int i = 0; i < BildschirmBreite; i++) {
			yWertArray[i] = funktion.calcY(i);
		}
	}

	public double[] getyWertArray() {
		return yWertArray;
	}
}
