package funktionswertBerechnung11a;

public class Tangens extends TrigonometrischeFunktion{

	public Tangens() {
		
	}
	
	public double f(double x) {
		return 400*Math.tan(Math.toRadians(x));
	}

}
