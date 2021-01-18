package funktionswertberechnung8;

import java.util.Scanner;

public class Funktionswertberechnung8 {

	public static void main(String[] args) {
		
		// Variablen deklarieren
		Scanner scanner =new Scanner(System.in);
		System.out.println("Bitte geben Sie die Anzahl der Koeffizienten im Polynom an.");
		int anzahlKoeffizienten = scanner.nextInt();
		double[] koeffizienten;
		double x=1;
		int maxExp;
		
		// Eingabe der Länge des Polynoms und damit des maximalen Exponenten
		koeffizienten = new double[anzahlKoeffizienten]; 
		// Die Zuweisung mit anzahlKoeffizienten funktioniert, weil Arrays in Java teildynamisch sind (im Gegensatz zu C)
		maxExp = koeffizienten.length-1;
		
		// x und Koeffizienten-Eingabe
		System.out.println("Geben Sie den Wert von x ein.");
		x = scanner.nextDouble();
		for(int i=maxExp; i>=0; i--) {
			System.out.printf("Bitte den Koeffizienten vor x");
			hochzahlausgabe(i);
			System.out.printf(" eingeben.\n");
			koeffizienten[i] = scanner.nextDouble();
			
		}
		
		// Ausgabe der Funktion mit Ergebnis
		System.out.print("f(" + x + ") = ");
		for(int zähler = maxExp; zähler>=0; zähler--) {
			System.out.print(koeffizienten[zähler] + " * " + x );
			hochzahlausgabe(zähler);
			if(zähler != 0) {
				System.out.print(" + ");
			}
		}
		System.out.print(" = " + f(koeffizienten, x, maxExp));
		
		scanner.close();
		return;
	}
	
	// Funktion, die Endergebnis berechnet
	static private double f (double[] koeffizienten, double x, int maxExp) {
		double ergebnis = 0;
		for(;maxExp>=0; maxExp--) {
			ergebnis += koeffizienten[maxExp] * Math.pow(x, maxExp);
		}
		return ergebnis;
	}
	
	//Funktion zur (schönen) Darstellung der Hochzahlen nötig, da ich bei einer Zahl nicht auf das erste Zeichen in dieser Zahl zugreifen kann, um es auszugeben
	static private void hochzahlausgabe(int i) {
		String stri = String.valueOf(i);
		for(int j=0; j<stri.length(); j++) {
			switch(stri.charAt(j)) {
			case '0': System.out.printf("\u2070"); break;
			case '1': System.out.printf("\u00B9"); break;
			case '2': System.out.printf("²"); break;
			case '3': System.out.printf("\u00B3"); break;
			case '4': System.out.printf("\u2074"); break;
			case '5': System.out.printf("\u2075"); break;
			case '6': System.out.printf("\u2076"); break;
			case '7': System.out.printf("\u2077"); break;
			case '8': System.out.printf("\u2078"); break;
			case '9': System.out.printf("\u2079"); break;
			}
		}
	}
}
