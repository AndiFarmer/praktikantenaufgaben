package testPackageF;

public class Calculator {
	public static double add (double a, double b) {
		return a+b;
	}
	
	public static double sub (double a, double b) {
		return a-b;
	}
	
	public static double mul (double a, double b) {
		return a*b;
	}
	
	public static double div (double a, double b) {
		if (b == 0) {
			System.out.println("Nicht durch Null teilen");
			return 0;
		}
		return a/b;
	}
	
	public static double mod (double a, double b) {
		if (b == 0) {
			System.out.println("Nicht durch Null teilen");
			return 0;
		}
		return a%b;
	}
	
}
