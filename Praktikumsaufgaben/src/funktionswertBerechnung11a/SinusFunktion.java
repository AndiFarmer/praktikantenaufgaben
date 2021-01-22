package funktionswertBerechnung11a;

public class SinusFunktion extends TrigonometrischeFunktion{

	public SinusFunktion() {
		
	}
	
	public double f(double x) {
		return 400*Math.sin(Math.toRadians(x));
	}

}
