package aufgabe9;

import java.util.Scanner;

public class Aufgabe9 {
	
	private static final int STELLEN = 4;
	public static void main(String[] args) {
		
		System.out.println("Geben Sie zwei Zahlen ein:");
		Scanner scanner = new Scanner(System.in);
		double input1 = scanner.nextDouble();
		double input2 = scanner.nextDouble(); //Camelcase
		double ergebnis = (input1/input2);
		
		System.out.println(input1 + "/" + input2 + "=" + ergebnis);
		System.out.printf("%.4f\n", ergebnis);	
		System.out.println(abschneiden(ergebnis));
		System.out.println(ergebnis);
		
		scanner.close();
	}
	
	private static double abschneiden(double input) {
		input = input * Math.pow(10, STELLEN);
		int abgeschnitten = (int) input; 
		double output = abgeschnitten;
		output = output / Math.pow(10, STELLEN);
		return output;
	}

}
