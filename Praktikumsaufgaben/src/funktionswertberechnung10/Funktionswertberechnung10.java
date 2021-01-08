package funktionswertberechnung10;

import java.util.Scanner;

public class Funktionswertberechnung10 {

	public static void main(String[] args) {
		double fx, a, b, c, p, q, x1, x2;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Zur Funktion f(x)= ax\u00B2+bx+c werden im folgenden die Lösungsmengen mit Hilfe der pq-Formel berechnet.");
		// Eingeben der benötigten Werte
		System.out.print("f(x) = ");
		fx = scanner.nextDouble();
		System.out.print("a = ");
		a = scanner.nextDouble();
		System.out.print("b = ");
		b = scanner.nextDouble();
		System.out.print("c = ");
		c = scanner.nextDouble();
		
		System.out.println(fx + " = " + a + "x\u00B2 + " + b + "x + " + c);
		
		//Vorbereitung
		
		c += fx; 	//Eine Seite der Gleichung muss Null sein
		b *= 1/a;	//der Koeffizient vor a muss 1 sein
		c *= 1/a;
		a *= 1/a;	//eigentlich optional, da a im Folgenden nicht mehr gebraucht wird
		
		//pq-Formel
		p = b;
		q = c;
		x1 = (-p/2) + ( Math.pow((Math.pow((p/2),2)-q),0.5) );
		x2 = (-p/2) - ( Math.pow((Math.pow((p/2),2)-q),0.5) );
		x1 = runden(x1);
		x1 = runden(x1);
		
		System.out.println("x1 = " + x1);
		System.out.println("x2 = " + x2);
		return;
	}

}
