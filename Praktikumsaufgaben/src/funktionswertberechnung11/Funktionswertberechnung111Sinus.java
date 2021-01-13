package funktionswertberechnung11;

public class Funktionswertberechnung111Sinus extends Funktionswertberechnung111 {

	
	public double f(double x) {
		//return Math.pow(0.1*x, 3) -0*Math.pow(x, 1) - 0*Math.pow(x, 0);
		//return Math.pow(0.01*x, 5)-1*Math.pow(x, 1)+100;
		return 400*Math.sin(Math.toRadians(x));
	}
	
	

}
