package aufgabe8;

import java.util.Scanner;

public class Aufgabe8 {

	public static void main(String[] args) {
		System.out.println("Geben Sie zwei Zahlen ein:");
		Scanner scanner = new Scanner(System.in);
		int input1 = scanner.nextInt();
		int input2 = scanner.nextInt();
		System.out.println(input1 + "/" + input2 + "=" + (input1/input2) + " Rest:" + (input1%input2));
		
		scanner.close();
	}

}
