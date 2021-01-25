package funktionswertBerechnung11a;

public class FunktionsWerte {

	private double[] yWertArray;
	private FunktionsZeichner funktionsZeichner;
		
	public FunktionsWerte(FunktionsZeichner funktionsZeichner) {
		this.funktionsZeichner = funktionsZeichner;
	}
	
//	public FunktionsWerte(BildschirmAbmessungen bildschirmAbmessungen) {
//		fillArray(bildschirmAbmessungen.getBreite());
//	}
	
	private void fillArray() {
		Funktion funktion = new PolynomFunktion();
		int bildschirmBreite = this.funktionsZeichner.getBildschirmAbmessungen().getBreite();
		yWertArray = new double[bildschirmBreite];
		for(int i = 0; i < bildschirmBreite; i++) {
			yWertArray[i] = funktion.calcY(i - (bildschirmBreite/2) );
		}
	}

	public double[] getyWertArray() {
		return yWertArray;
	}
	
}
