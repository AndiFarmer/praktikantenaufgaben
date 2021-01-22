package funktionswertBerechnung11a;

public class TangensFunktion extends TrigonometrischeFunktion{

	public TangensFunktion() {
		
	}
	
	public double f(double x) {
		return 400*Math.tan(Math.toRadians(x));
	}

}
