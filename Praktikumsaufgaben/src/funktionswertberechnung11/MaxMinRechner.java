package funktionswertberechnung11;

public class MaxMinRechner {

	private double xMin = 0;
	private double xMax = 0;
	private double yMin = 0;
	private double yMax = 0;
	
	public MaxMinRechner() {
		
	}
	
	public double calcXYMaxMin(Fenster fenster, Point[] punktArray) {
		
		double fensterbreiteUrsprünglich = fenster.getFensterBreiteUrsprünglich();
		double fensterHöhe = fenster.getFensterHöhe();
		double fensterBreite = fenster.getFensterBreite();
		boolean xMinGesetzt = false;
		double yNow = 0;
		
		for (double xNow = -fensterBreite/2; xNow <= fensterBreite/2; xNow++) {
			yNow = punktArray[(int) (xNow+ fensterbreiteUrsprünglich/2) ].getYKoordinate();
			
			if (yNow < fensterHöhe/2 && yNow > -fensterHöhe/2 && xMinGesetzt == false) {
				xMin = xNow;
				xMinGesetzt = true;
			}
			if (yNow < fensterHöhe/2 && yNow > -fensterHöhe/2) {
				xMax = xNow;
			}
			if(yNow < yMin && yNow >= -fensterHöhe/2) {
				yMin = yNow;
			}
			if (yNow > yMax && yNow <= fensterHöhe/2) {
				yMax = yNow;
			}
		}
		xMinGesetzt = false;
		return xMin;
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


