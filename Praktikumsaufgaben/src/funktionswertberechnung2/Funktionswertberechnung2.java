package funktionswertberechnung2;

// import java.math.BigDecimal;

public class Funktionswertberechnung2 {

	private static final double STELLEN = 4;

	public static void main(String[] args) {
		double beispielzahl = 5;
		System.out.println("f("+beispielzahl+")=2*cos(x)+3\nf("+beispielzahl+")=" + f(beispielzahl));
	}
	/*
	private static BigDecimal f (BigDecimal x) {
		BigDecimal multiplier = new BigDecimal("2");
		BigDecimal cosine = new BigDecimal("4");
		BigDecimal addend = new BigDecimal("3");
		x = x.cos(cosine);
		x = x.multiply(multiplier);
		x = x.add(addend);
		return x;
		
	}
	*/
	
	private static double f (double x) {
		return runden(2 * Math.cos((Math.toRadians(x))) + 3);		
	}
	
	private static double runden(double input) {
		input = input * Math.pow(10, STELLEN);
		int abgeschnitten = (int) input; 
		double rest = input - abgeschnitten;
		if (rest > 0.4) {
			abgeschnitten++;
		}
		double output = abgeschnitten;
		output = output / Math.pow(10, STELLEN);
		return output;
	}
}
