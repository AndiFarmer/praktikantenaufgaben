package aufgabe10;

import java.util.Scanner;

public class Aufgabe10 {
	
	private static final int STELLEN = 4;
	
	public static void main(String[] args) {
		
		System.out.println("Geben Sie zwei Zahlen ein:");
		Scanner scanner = new Scanner(System.in);
		double input1 = scanner.nextDouble();
		double input2 = scanner.nextDouble(); //Camelcase
		double ergebnis = (input1/input2);
		
		System.out.println(input1 + "/" + input2 + "=" + ergebnis);
		System.out.println("bzw. " + runden(ergebnis));
	}
	
	private static double runden(double input) {
		input = (input * Math.pow(10, STELLEN)) + 0.5;
		int abgeschnitten = (int) input;
		double output = abgeschnitten;
		output = output / Math.pow(10, STELLEN);
		return output;
	}

}