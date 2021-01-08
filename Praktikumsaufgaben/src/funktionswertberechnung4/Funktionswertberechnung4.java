package funktionswertberechnung4;

public class Funktionswertberechnung4 {

	public static void main(String[] args) {
		double xmin=-1, xmax=3, delta=1;
		System.out.println("f(x) = 2 * x - 4");
		for(double zähler=xmin; zähler<=xmax; zähler+=delta) {
			System.out.println("f("+zähler+") = "+f(zähler));
		}
	}
	
	static private double f(double x) {
		return 2*x-4;
	}

}
