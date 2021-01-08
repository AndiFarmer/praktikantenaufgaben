package funktionswertberechnung6;

import java.util.Scanner;

public class Funktionswertberechnung6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Für welche Funktion wollen Sie einen Wertebereich ausgegeben haben, 1(f(x)=(cos(x)+3)^3) oder 2(f(x)= x^x + x^(-x))?");
		int entscheidung = scanner.nextInt();
		switch (entscheidung) {
		case 1: for (double zähler=-2; zähler<=2; zähler++) {
					System.out.println("f1("+zähler+") =  "+f1(zähler));
				}  break;
			
		case 2: for (double zähler=-2; zähler<=2; zähler++) {
					System.out.println("f2("+zähler+") =  "+f2(zähler));
				}  break;
		}

	}
	
	static private double f1(double x) {
		//f(x)=(cos(x)+3)^3
		return Math.pow(Math.cos((Math.toRadians(x)))+3, 3);
	}
	
	static private double f2(double x) {
		//f(x)= x^x + x^(-x)
		return Math.pow(x,x)+Math.pow(x, -x);
	}
	
}
