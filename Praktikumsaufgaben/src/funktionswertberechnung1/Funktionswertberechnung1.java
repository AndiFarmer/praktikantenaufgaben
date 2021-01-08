package funktionswertberechnung1;

import java.math.BigDecimal;

public class Funktionswertberechnung1 {

	public static void main(String[] args) {
		BigDecimal beispielzahl = new BigDecimal("3");
		System.out.println("f(x)=2*x-4\nf(3)=" + f(beispielzahl));
	}
	
	private static BigDecimal f (BigDecimal x) {
		BigDecimal multiplier = new BigDecimal("2");
		BigDecimal subtrahend = new BigDecimal("4");
		x = x.multiply(multiplier);
		x = x.subtract(subtrahend);
		
		return x;	
	}
}
