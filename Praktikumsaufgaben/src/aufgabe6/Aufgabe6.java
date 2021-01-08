package aufgabe6;

import java.util.Scanner;

public class Aufgabe6 {

	public static void main(String[] args) {
		System.out.println("Geben Sie zwei Zahlen ein:");
		Scanner scanner = new Scanner(System.in);
		double input1 = scanner.nextDouble();
		double input2 = scanner.nextDouble();
		System.out.println(input1 + "/" + input2 + "=" + (input1/input2));
	}
	

}
