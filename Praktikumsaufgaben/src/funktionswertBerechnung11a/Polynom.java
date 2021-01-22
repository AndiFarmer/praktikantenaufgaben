package funktionswertBerechnung11a;

public class Polynom extends QuadratischeFunktion{

	public Polynom() {
		
	}
	
	public double f(double x) {
		return Math.pow(0.01*x, 5)-1*Math.pow(x, 1)+100;
	}
}
