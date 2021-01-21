package funktionswertberechnung11;

public abstract class Graph {

	private Point[] punktArray;
	private double xMin = 0;
	private double xMax = 0;
	private double yMin = 0;
	private double yMax = 0;
	
	public Graph(Fenster fenster) {
		füllePunktArray(fenster);
		calcXYMaxMin(fenster, punktArray);
		
	}
	
	private void füllePunktArray(Fenster fenster) {
		
		double fensterBreiteUrsprünglich = fenster.getFensterBreiteUrsprünglich();
		punktArray = new Point[(int) (fensterBreiteUrsprünglich+1)];
		
		for (double xNow = -fensterBreiteUrsprünglich/2; xNow <= fensterBreiteUrsprünglich/2; xNow++) {
			double yNow = f(xNow);
			punktArray[(int) (xNow + fensterBreiteUrsprünglich/2)] = new Point(xNow, yNow);
		}
	}
	
	abstract double f(double x);
		
	
	
	public double calcXYMaxMin(Fenster fenster, Point[] punktArray) {
		
		double fensterHöheUrsprünglich = fenster.getFensterHöheUrsprünglich();
		double fensterBreiteUrsprünglich = fenster.getFensterBreiteUrsprünglich();;
		boolean xMinGesetzt = false;
		double yNow = 0;
		
		for (double xNow = -fensterBreiteUrsprünglich/2; xNow <= fensterBreiteUrsprünglich/2; xNow++) {
			yNow = punktArray[(int) (xNow+ fensterBreiteUrsprünglich/2) ].getYKoordinate();
			
			if (yNow < fensterHöheUrsprünglich/2 && yNow > -fensterHöheUrsprünglich/2 && xMinGesetzt == false) {
				xMin = xNow;
				xMinGesetzt = true;
			}
			if (yNow < fensterHöheUrsprünglich/2 && yNow > -fensterHöheUrsprünglich/2) {
				xMax = xNow;
			}
			if(yNow < yMin && yNow >= -fensterHöheUrsprünglich/2) {
				yMin = yNow;
			}
			if (yNow > yMax && yNow <= fensterHöheUrsprünglich/2) {
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
	public Point[] getPunktArray() {
		return punktArray;
	}
}


