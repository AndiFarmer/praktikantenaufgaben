package funktionswertberechnung11;

public class MaxMinRechner {
	
	public MaxMinRechner() {
		
	}
	
	public static double xMin(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		boolean xMinGesetzt = false;
		double xMin = 0;
		double xNow = 0;
		double yNow = 0;
		
		for (double xWert = -fensterbreite/2; xWert <= fensterbreite/2; xWert++) {
			xNow = xWert;
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();
			
			if (yNow < fensterhöhe/2 && yNow > -fensterhöhe/2 && xMinGesetzt == false) {
				xMin=xNow;
				xMinGesetzt = true;
			}
		}
		return xMin;
	}
	
	public static double xMax(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		double xMax = 0;
		double xNow = 0;
		double yNow = 0;
		
		for (double xWert = -fensterbreite/2; xWert <= fensterbreite/2; xWert++) {
			xNow = xWert;
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();
			
			if (yNow < fensterhöhe/2 && yNow > -fensterhöhe/2) {
				xMax=xNow;
			}
		}
		return xMax;
	}
	
	public static double yMin(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		double yMin = 0;
		double xNow = 0;
		double yNow = 0;
		
		for (double xWert = -fensterbreite/2; xWert <= fensterbreite/2; xWert++) {
			xNow = xWert;
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();
			
			if(yNow < yMin && yNow >= -fensterhöhe/2) {
				yMin=yNow;
			}
		}
		return yMin;
	}
	
	public static double yMax(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		double yMax = 0;
		double xNow = 0;
		double yNow = 0;
		
		for (double xWert = -fensterbreite/2; xWert <= fensterbreite/2; xWert++) {
			xNow = xWert;
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();

			if (yNow > yMax && yNow <= fensterhöhe/2) {
				yMax=yNow;
			} 
		}
		return yMax;
	}
}
