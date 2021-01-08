package aufgabe12;

import java.math.BigDecimal;

public class Aufgabe12 {

	public static void main(String[] args) {
		BigDecimal zahl = new BigDecimal("0");
		BigDecimal zahl1 = new BigDecimal("0.3");
		BigDecimal zahl2 = new BigDecimal("5.1");
		System.out.println(zahl.add(zahl1).add(zahl2));
	}

}
