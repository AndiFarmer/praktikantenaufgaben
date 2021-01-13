package funktionswertberechnung11;

import funktionswertberechnung11.Funktionswertberechnung111Point;

public class Funktionswertberechnung111Starter {

	public static void main(String[] args) {
		Funktionswertberechnung111Sinus instanz1 = new Funktionswertberechnung111Sinus();
		//Funktionswertberechnung111Polynom instanz2 = new Funktionswertberechnung111Polynom();
		Funktionswertberechnung111Point punkt= new Funktionswertberechnung111Point();
		punkt.setPoint(2, 1);
		System.out.println(punkt.getXKoordinate() + " " +punkt.getYKoordinate());
		

	}

}
