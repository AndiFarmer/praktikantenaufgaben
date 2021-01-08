package funktionswertberechnung11;

import java.util.Scanner;

public class Funktionswertberechnung11 {

	public static void main(String[] args) {
		
		for(int i=-5; i<=150; i++) {
			if(i%10==0) {
				System.out.print(i-(i/10)*9);
			} else {
				System.out.print(" ");
			}
		}
		System.out.print("\n");
		
		for(int i=-5; i<=150; i++) {
			if(i%10==0) {
				System.out.print("|");
			} else {
				System.out.print(" ");
			}
		}
		System.out.print("\n");
			
		
		
		for(double i=-12 ; i<=12 ; i+=0.5) {
			System.out.printf("%5.2f", Math.pow(Math.pow(i, 2), 0.5));
			for(int j=0; j<=f(i) && f(i)>0 ; j++) {
				System.out.print(" ");
			}
			if(f(i) >= 0) {
				System.out.print(".");
			}
			System.out.print("\n");
			
		}
		
		System.exit(0);	
	}
	
	static private double f(double x) {
		return Math.pow(x, 2);
	}
}
