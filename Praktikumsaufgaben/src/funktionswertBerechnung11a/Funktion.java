package funktionswertBerechnung11a;

abstract public class Funktion {

	public Funktion() {
		
	}
	
	public double calcY(double x) {
		return f(x);
	}

	abstract double f(double x);
}
