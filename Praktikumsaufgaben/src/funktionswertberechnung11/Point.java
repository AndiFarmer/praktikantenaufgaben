package funktionswertberechnung11;

public class Point {
	
	private double xKoordinate=0;
	private double yKoordinate=0;
	
	public Point (double xInput, double yInput) {
		this.xKoordinate = xInput; // this ist impliziert
		this.yKoordinate = yInput;
	}
	
	public void setPoint(double xInput, double yInput) {
		this.xKoordinate = xInput;
		this.yKoordinate = yInput;
	}
	
	public void setXKoordinate(double xInput) {
		this.xKoordinate = xInput;
	}
	
	public void setYKoordinate(double yInput) {
		this.xKoordinate = yInput;
	}
	
	public Point getPoint() {
		return this;
	}
	
	public double getXKoordinate() {
		return this.xKoordinate;
	}
	
	public double getYKoordinate() {
		return this.yKoordinate;
	}
	
	public String toString() {
		return this.getClass().getName() + " instance (" + xKoordinate + ";" +yKoordinate + ")" ;
	}
}
