package funktionswertberechnung11;

/**
 * 
 * @author z1300a2k
 *
 */
public class Polynom extends Graph {
	
	public Polynom(Fenster fenster) {
		super(fenster);
	}

	public double f(double x) {
		return Math.pow(0.01*x, 5)-1*Math.pow(x, 1)+100;
	}
	
	

}
