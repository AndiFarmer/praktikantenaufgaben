package funktionswertberechnung5;

import java.util.Scanner;

public class Funktionswertberechnung5 {

	public static void main(String[] args) {
		double xmin, xmax, delta;
		System.out.println("Geben Sie den Bereichsanfang und das Ende ein, sowie den Abstand der x-Werte");
		System.out.println("Die Eingaben bitte jeweils mit Enter bestätigen.");
		System.out.println("Die Funktion lautet: f(x) = 2*x-4");
		xmin = eingabe();
		xmax = eingabe();
		delta = eingabe();
		
		for(double zähler=xmin; zähler<=xmax; zähler+=delta) {
			System.out.println("f("+zähler+") = 2*"+zähler+"-4 = "+f(zähler));
		}
	}
	
	static private double eingabe() {
		Scanner scanner= new Scanner(System.in);
		scanner.close();
		return scanner.nextDouble();
	}
	
	static private double f(double x) {
		return 2*x-4;
	}

}
