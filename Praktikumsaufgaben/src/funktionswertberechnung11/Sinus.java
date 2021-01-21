package funktionswertberechnung11;

public class Sinus extends Graph {

	public Sinus(Fenster fenster) {
		super(fenster);
	}

	public double f(double x) {
		return 400*Math.sin(Math.toRadians(x));
	}
}
