package funktionswertberechnung11;

public class MaxMinRechner {

	private double xMin = 0;
	private double xMax = 0;
	private double yMin = 0;
	private double yMax = 0;
	
	public MaxMinRechner() {
		
	}
	
	public double calcXMin(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		boolean xMinGesetzt = false;
		
		double yNow = 0;
		
		for (double xNow = -fensterbreite/2; xNow <= fensterbreite/2; xNow++) {
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();
			
			if (yNow < fensterhöhe/2 && yNow > -fensterhöhe/2 && xMinGesetzt == false) {
				xMin = xNow;
				xMinGesetzt = true;
			}
		}
		xMinGesetzt = false;
		return xMin;
	}
	
	public double calcXMax(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		
		double yNow = 0;
		
		for (double xNow = -fensterbreite/2; xNow <= fensterbreite/2; xNow++) {
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();
			
			if (yNow < fensterhöhe/2 && yNow > -fensterhöhe/2) {
				xMax = xNow;
			}
		}
		return xMax;
	}
	
	public double calcYMin(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		yMin = fensterhöhe/2; 
		double yNow = 0;
		
		for (double xNow = -fensterbreite/2; xNow <= fensterbreite/2; xNow++) {
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();
			
			if(yNow < yMin && yNow >= -fensterhöhe/2) {
				yMin = yNow;
			}
		}
		return yMin;
	}
	
	public double calcYMax(double fensterbreite, double fensterhöhe, Point[] punktArray, double fensterbreiteUrsprünglich) {
		yMax = -(fensterhöhe/2);
		double yNow = 0;
		
		for (double xNow = -fensterbreite/2; xNow <= fensterbreite/2; xNow++) {
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();

			if (yNow > yMax && yNow <= fensterhöhe/2) {
				yMax = yNow;
			} 
		}
		return yMax;
	}
	
	
	public double getXMin() {
		return xMin;
	}
	public double getXMax() {
		return xMax;
	}
	public double getYMin() {
		return yMin;
	}
	public double getYMax() {
		return yMax;
	}
}


