package funktionswertberechnung7;

import java.util.Scanner;

public class Funktionswertberechnung7 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		scanner.close();
		double koeffizienten[] = {1,1,1};
		double x=1;
		int maxExp = 2;
		
		System.out.println("Geben Sie zu der Polynomfunktion f(x) = x^2 + x^1 + x^0 die Koeffizienten ein und zuletzt x.");
		for(int i=koeffizienten.length-1; i>=0; i--) {
			koeffizienten[i] = scanner.nextDouble();
		}
		x = scanner.nextDouble();
		
		int maxExpCopy = maxExp;
		System.out.printf("f(%.2f) = ", x);
		for(;maxExpCopy>=0; maxExpCopy--) {
			System.out.printf("%.2f*%.2f^%d", koeffizienten[maxExpCopy], x, maxExpCopy );
			if(maxExpCopy != 0) {
				System.out.printf(" + ");
			}
		}
		System.out.printf(" = %.2f", f(koeffizienten, x, maxExp));
	}
	
	static private double f (double[] koeffizienten, double x, int maxExp) {
		double ergebnis = 0;
		for(;maxExp>=0; maxExp--) {
			ergebnis += koeffizienten[maxExp] * Math.pow(x, maxExp);
		}
		return ergebnis;
	}

}
