package funktionswertberechnung3;

import java.math.BigDecimal;
import java.util.Scanner;

public class Funktionswertberechnung3 {
	
	private static final double STELLEN = 4;

	public static void main(String[] args) {
		double xmin, xmax, xdelta;
		System.out.println("Geben Sie den Wert von Xmin, Xmax und Delta ein. Bestätigen der Eingabe jeweils mit Enter");
		xmin = Einlesen();
		xmax = Einlesen();
		xdelta = Einlesen();
		
		for(double d=xmin; d<=xmax; d+=xdelta) {
			System.out.println("f("+d+")=2*sin("+d+")-4 = "+f(d));
		}
		
	}
	
	private static double Einlesen () {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextDouble();
	}
	
	private static double f (double x) {
		return runden(2 * Math.sin((Math.toRadians(x))) - 4);		
	}
	
	private static double runden(double input) {
		input = input * Math.pow(10, STELLEN);
		int abgeschnitten = (int) input; 
		double rest = input - abgeschnitten;
		if (rest > 0.4) {
			abgeschnitten++;
		}else if(rest < -0.4) {
			abgeschnitten--;
		}
			
		double output = abgeschnitten;
		output = output / Math.pow(10, STELLEN);
		return output;
	}
}
