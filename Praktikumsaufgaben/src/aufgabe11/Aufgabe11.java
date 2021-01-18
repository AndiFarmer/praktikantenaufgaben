package aufgabe11;

import java.util.Scanner;

public class Aufgabe11 {
	
	public static void main(String[] args) {
		
		System.out.println("Geben Sie zwei Zahlen ein:");
		Scanner scanner = new Scanner(System.in);
		double input1 = scanner.nextDouble();
		double input2 = scanner.nextDouble(); //Camelcase
		double ergebnis = (input1/input2);
		String ergebnisstring = String.valueOf(ergebnis);
		ergebnisstring = ergebnisstring + "0";
		System.out.println(ergebnisstring);
		// int differenz = 0; 
		for(int i = 0; i < ergebnisstring.length(); i++ ) {
			if(ergebnisstring.charAt(i) == '.') {
				for (int j = 0; j < 3; j++) {
					System.out.printf("%c", ergebnisstring.charAt(i+j));
				}
				break;
			}
			System.out.printf("%c", ergebnisstring.charAt(i));
		}
		int punktIndex = ergebnisstring.indexOf('.');
		System.out.println(ergebnisstring.substring(0, punktIndex+3));
		System.out.println("\nOhne Schneiden:" + ergebnis);
		
		scanner.close();
	}
		
}
