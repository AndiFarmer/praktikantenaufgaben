package funktionswertBerechnung11a;

public class Sinus extends TrigonometrischeFunktion{

	public Sinus() {
		
	}
	
	public double f(double x) {
		return 400*Math.sin(Math.toRadians(x));
	}

}
